package ru.platformaofd.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.platformaofd.api.response.CodeMessageResponse;
import ru.platformaofd.exception.TechnicalException;
import ru.platformaofd.exception.UserAlreadyExistsException;
import ru.platformaofd.exception.UserNotExistException;
import ru.platformaofd.model.Balance;
import ru.platformaofd.model.User;
import ru.platformaofd.model.enums.BalanceType;
import ru.platformaofd.model.enums.Code;
import ru.platformaofd.model.enums.Role;
import ru.platformaofd.repository.UserRepository;
import ru.platformaofd.util.Utils;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BalanceService balanceService;
    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, BalanceService balanceService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.balanceService = balanceService;
        this.authenticationManager = authenticationManager;
    }


    /**
     * Метод регистрации пользователя
     * @param login логин пользователя
     * @param password пароль пользователя
     * @return строка с сообщением в случае успешной регистрации
     */
    public CodeMessageResponse register(String login, String password) {
        // проверяем существование пользователя в базе
        checkExistingInDbByLogin(login);
        // все пользователи по умолчанию получают роль USER
        saveUser(new User(login, Utils.encodePassword(password), Role.USER));

        return new CodeMessageResponse(String.format("Пользователь с логином %s успешно зарегистрирован", login), Code.OK);
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
                    Code.USER_IS_EXISTS.getCode()
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
                    Code.TECHNICAL.getCode()
            );
        }
    }

    /**
     * Метод входа в приложение для зарегистрированных пользователей
     * @param login логин пользователя
     * @param password пароль пошльзователя
     * @return строка с сообщением, в случае успешного входа
     */
    public CodeMessageResponse login(String login, String password) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login, password));

        SecurityContextHolder.getContext().setAuthentication(auth);
        return new CodeMessageResponse("Вы вошли в систему", Code.OK);
    }

    public CodeMessageResponse logout() {
        SecurityContextHolder.clearContext();
        return new CodeMessageResponse("Вы вышли из системы", Code.OK);
    }

    /**
     * Метод получения авторизированного пользователя
     * @return объект User - авторизированный пользователь
     */
    public User getLoggedUser() {
        //TODO Изменить получение списка балансов по условию ТЗ (стрим)
        String loggedUserLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedUser = getByLogin(loggedUserLogin);

        loggedUser.setBalanceList(getAllBalancesByUserId(loggedUser.getId()));
        return loggedUser;
    }

    /**
     * Метод получения пользователя по логину
     * @param login логин пользователя
     * @return пользователь(объект User)
     * @throws UserNotExistException в случае, если пользователь с таким логином не существует в базе
     */
    public User getByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(() -> new UserNotExistException(
                        String.format("Пользователя с логином %s не существует", login),
                        Code.USER_NOT_EXISTS.getCode())
        );
    }

    /**
     * Метод получения списка всех балансов по id пользователя
     * @return список балансов пользователя
     */
    public List<Balance> getAllBalancesByUserId(Long userId) {
        return balanceService.getAllBalancesByUserId(userId);
    }

    /**
     * Метод добавления нового баланса для авторизированного пользователя
     * @param type тип баланса
     * @param count скол-во средств на счету баланса
     * @return строка с сообщением, в случае успешного добавления
     */
    public CodeMessageResponse addNewBalance(BalanceType type, long count) {
        User loggedUser = getLoggedUser();

        balanceService.saveBalance(new Balance(loggedUser.getId(), type, count));
        return new CodeMessageResponse(
                String.format("Баланс для пользователя \"%s\" успешно добавлен", loggedUser.getLogin()),
                Code.OK);
    }
}
