package ru.platformaofd.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.platformaofd.model.enums.BalanceType;
import ru.platformaofd.model.enums.Role;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Вспомогательный класс различных преобразований
 */
public abstract class Utils {

    /**
     * Метод преобразования строкового представления даты из базы данных в объект LocalDateTime
     * @param str строковое представление даты из базы данных
     * @return объект LocalDateTime
     */
    public static LocalDateTime getLocalDateTimeFromString(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return LocalDateTime.parse(str.replaceFirst("[\\.].*", ""), formatter);
    }

    /**
     * Метод преобразования строкового представления типа баланса в значение BalanceType
     * @param str строковое представление типа баланса
     * @return значение BalanceType
     */
    public static BalanceType getBalanceTypeFromString(String str) {
        return BalanceType.valueOf(str);
    }

    /**
     * Метод преобразования LocalDateTime к строковому представлению
     * @param time объект LocalDateTime
     * @return строка с датой
     */
    public static String getPrettyStringFromLocalDateTime(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
    }

    /**
     * Метод кодирования пароля в закодированную строку
     * @param password незакодированный пароль
     * @return строка с закодированным паролем
     */
    public static String encodePassword(String password) {
        return new BCryptPasswordEncoder(12).encode(password);
    }

    /**
     * Метод преобразования строкового представления роли пользователя в значение Role
     * @param str строковое представление роли пользователя
     * @return значение Role
     */
    public static Role getRoleFromString(String str) {
        return Role.valueOf(str);
    }
}
