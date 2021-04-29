package ru.platformaofd.exception;

/**
 * Класс исключений в случае, если пользователь не существует
 */
public class UserNotExistException extends AbstractApplicationException{

    public UserNotExistException(String message, int errorCode) {
        super(message, errorCode);
    }
}
