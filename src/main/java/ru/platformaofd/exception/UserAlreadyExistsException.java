package ru.platformaofd.exception;

/**
 * Класс исключений в случае, если пользователь существует
 */
public class UserAlreadyExistsException extends AbstractApplicationException{

    public UserAlreadyExistsException(String message, int errorCode) {
        super(message, errorCode);
    }
}
