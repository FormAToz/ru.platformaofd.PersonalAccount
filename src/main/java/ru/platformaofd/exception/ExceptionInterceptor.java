package ru.platformaofd.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

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
            Exception.class
    })
    public ModelAndView handleUserAlreadyExistsException(HttpServletRequest request,
                                                         HttpServletResponse response,
                                                         Exception ex)
    {
        //TODO удалить перед продакшеном
        ex.printStackTrace();
        return new ModelAndView("errorPage", "ex", ex);
    }
}
