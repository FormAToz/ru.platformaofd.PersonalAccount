package ru.platformaofd.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import ru.platformaofd.model.enums.BalanceType;
import ru.platformaofd.util.Utils;

import java.time.LocalDateTime;

/**
 * Класс отображения баланса пользователя
 */
public class Balance {

    @Id
    private Long id;

    @Column("user_id")
    private Long userId;

    private Long count;

    private BalanceType type;

    private LocalDateTime created;


    public Balance() {
        this.created = LocalDateTime.now();
    }

    public Balance(Long userId, BalanceType type, Long count) {
        this.created = LocalDateTime.now();
        this.userId = userId;
        this.count = count;
        this.type = type;
    }

    public Balance(Long id, Long userId, Long count, BalanceType type, LocalDateTime created) {
        this.id = id;
        this.userId = userId;
        this.count = count;
        this.type = type;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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

    /**
     * Метод преобразования LocalDateTime к строковому представлению
     * @return строка с датой
     */
    public String getCreatedPretty() {
        return Utils.getPrettyStringFromLocalDateTime(this.created);
    }
}
