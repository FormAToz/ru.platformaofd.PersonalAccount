package ru.platformaofd.model;

import ru.platformaofd.model.enums.BalanceType;

import java.time.LocalDateTime;

/**
 * Класс отображения баланса пользователя
 */
public class Balance {

    private String name;
    private BalanceType type;
    private LocalDateTime created;

    public Balance(String name, BalanceType type) {
        created = LocalDateTime.now();
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BalanceType getType() {
        return type;
    }

    public void setType(BalanceType type) {
        this.type = type;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
