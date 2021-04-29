package ru.platformaofd.exception;

/**
 * Класс исключений в случае, если введен неверный пароль
 */
public class PasswordIncorrectException extends AbstractApplicationException{
    public PasswordIncorrectException(String message, int errorCode) {
        super(message, errorCode);
    }
}
