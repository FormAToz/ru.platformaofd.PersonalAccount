package ru.platformaofd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.platformaofd.model.User;
import ru.platformaofd.util.Utils;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Repository
public class UserRepository {

    private final String SELECT_ALL = "select * from users";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;

    /**
     * Инициализация таблицы
     */
    @PostConstruct
    private void initDB() {
        System.out.println("Creating table users...");

        jdbcTemplate.execute("DROP TABLE users IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE users(" +
                "id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY, " +
                "login VARCHAR(255), " +
                "password VARCHAR(255), " +
                "role VARCHAR(100))");
    }

    /**
     * Сохранение пользователя
     * @param user объект пользователя
     * @return целочисленное значение - кол-во записей, в случае успешной вставки в базу
     */
    public int save(User user) {
        return jdbcTemplate.update(
                "insert into users(login, password, role) values(?,?,?)",
                user.getLogin(), user.getPassword(), user.getRole().name()
        );
    }

    /**
     * Метод проверки существования пользователя в базе по логину
     * @param login логин пользователя
     * @return true в случае, если пользователь существует, false если пользователь отсутствует в базе
     */
    public boolean existsByLogin(String login) {
        return jdbcTemplate.queryForList(
                        SELECT_ALL + " where upper(login) like ?",
                        login.toUpperCase())
                .size() > 0;
    }

    /**
     * Метод получения пользователя по логину
     * @param login логин пользователя
     * @return объект Optional<User>
     */
    public Optional<User> findByLogin(String login) {
        return namedParameterJdbcOperations.queryForObject(
                SELECT_ALL + " where upper(login) like :login",
                new MapSqlParameterSource("login", login.toUpperCase()),
                (rs, rowNum) -> Optional.of(new User(
                        rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        Utils.getRoleFromString(rs.getString("role"))
                        ))
        );
    }
}
