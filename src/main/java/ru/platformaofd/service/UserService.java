package ru.platformaofd.service;

import org.springframework.stereotype.Service;
import ru.platformaofd.exception.TechnicalException;
import ru.platformaofd.exception.UserAlreadyExistsException;
import ru.platformaofd.model.Balance;
import ru.platformaofd.model.User;
import ru.platformaofd.model.enums.BalanceType;
import ru.platformaofd.model.enums.ErrorCode;
import ru.platformaofd.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BalanceService balanceService;

    public UserService(UserRepository userRepository, BalanceService balanceService) {
        this.userRepository = userRepository;
        this.balanceService = balanceService;
    }


    /**
     * Метод регистрации пользователя
     * @param login логин пользователя
     * @param password пароль пользователя
     * @return строка с сообщением в случае успешной регистрации
     */
    public String register(String login, String password) {
        //FIXME переделать, когда подключится security
        checkExistingInDbByLogin(login);
        saveUser(new User(login, password));

        return String.format("Пользователь с логином %s успешно зарегистрирован", login);
    }

    /**
     * Метод проверки пользователя по логину в базе
     * @param login логин пользователя
     * @throws UserAlreadyExistsException в случае, если пользователь уже существует в базе
     */
    private void checkExistingInDbByLogin(String login) {
        if (userRepository.existsByLogin(login)) {
            throw new UserAlreadyExistsException(
                    String.format("Пользователь с логином %s уже зарегистрирован", login),
                    ErrorCode.USER_IS_EXISTS.getCode()
            );
        }
    }

    /**
     * Метод сохранения пользователя в базу
     * @param user объект пользователя
     * @throws TechnicalException в случае ошибки сохранения
     */
    private void saveUser(User user) {
        if (userRepository.save(user) == 0) {
            throw new TechnicalException(
                    String.format("Ошибка регистрации пользователя с логином %s", user.getLogin()),
                    ErrorCode.TECHNICAL.getCode()
            );
        }
    }

    /**
     * Метод входа в приложение для зарегестрированных пользователей
     * @param login логин пользователя
     * @param password пароль пошльзователя
     * @return строка с сообщением, в случае успешного входа
     */
    public String login(String login, String password) {
        //FIXME оставить проверку логина и пароля для security
        return "Вы вошли в систему";
    }

    /**
     * Метод получения авторизированного пользователя
     * @return объект User - авторизированный пользователь
     */
    public User getLoggedUser() {
        //TODO сменить. когда будет security

        //TODO Изменить получение списка балансов по условию ТЗ (стрим)

        User loggedUser = new User(1L, "Test Login", "Test Password", getAllBalancesByUserId(1L));

        return loggedUser;
    }

    /**
     * Метод получения списка всех балансов по id пользователя
     * @return список балансов пользователя
     */
    public List<Balance> getAllBalancesByUserId(Long userId) {
        return balanceService.getAllBalancesByUserId(userId);
    }

    /**
     * Метод получения всех зарегестрированных пользователей
     * @return Список зарегистрированных пользователей
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * Метод добавления нового баланса для авторизированного пользователя
     * @param type тип баланса
     * @param count скол-во средств на счету баланса
     * @return строка с сообщением, в случае успешного добавления
     */
    public String addNewBalance(BalanceType type, long count) {
        User loggedUser = getLoggedUser();

        balanceService.saveBalance(new Balance(loggedUser.getId(), type, count));
        return String.format("Баланс для пользователя \"%s\" успешно добавлен", loggedUser.getLogin());
    }
}
