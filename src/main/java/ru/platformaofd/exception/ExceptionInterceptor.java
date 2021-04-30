package ru.platformaofd.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.platformaofd.model.enums.ErrorCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Класс обработки всех исключений на уровне контроллера
 */
@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(value = {
            UserAlreadyExistsException.class,
            PasswordIncorrectException.class,
            TechnicalException.class,
            UserNotExistException.class,
            AuthenticationException.class,
            AccessDeniedException.class
    })
    public ModelAndView handleUserAlreadyExistsException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        ex.printStackTrace();

        // в случае ввода неверного логина/пароля
        if (ex instanceof AuthenticationException) {
            ex = new TechnicalException("Логин или пароль введены неверно!", ErrorCode.PASSWORD_INCORRECT.getCode());
        }

        // в случае доступа без предварительной авторизации
        if (ex instanceof AccessDeniedException) {
            ex = new TechnicalException("Авторизируйтесь, чтобы получить доступ!", ErrorCode.TECHNICAL.getCode());
        }

        return new ModelAndView("errorPage", "ex", ex);
    }
}