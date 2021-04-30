package ru.platformaofd.api.response;

import ru.platformaofd.model.enums.Code;

/**
 * Класс ответа, содержащий сообщение и код
 */
public class CodeMessageResponse {

    private final String message;
    private final Code code;

    public CodeMessageResponse(String message, Code code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Code getCode() {
        return code;
    }
}
