package ru.platformaofd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.platformaofd.model.User;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class UserRepository {

    private final String SELECT_ALL = "select * from users";

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
                "password VARCHAR(255))");
    }

    /**
     * Сохранение пользователя
     * @param user объект пользователя
     * @return целочисленное значение - кол-во записей, в случае успешной вставки в базу
     */
    public int save(User user) {
        return jdbcTemplate.update(
                "insert into users(login, password) values(?,?)",
                user.getLogin(), user.getPassword()
        );
    }

    /**
     * Получение списка всех пользователей
     * @return List<User> - список всех пользователей
     */
    public List<User> getAll() {
        return jdbcTemplate.query(SELECT_ALL,
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("password")
                )
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
}
