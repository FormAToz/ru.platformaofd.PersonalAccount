package ru.platformaofd.exception;

/**
 * Класс исключений в случае технических ошибок приложения
 */
public class TechnicalException extends AbstractApplicationException{

    public TechnicalException(String message, int errorCode) {
        super(message, errorCode);
    }
}
