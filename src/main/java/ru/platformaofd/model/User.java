package ru.platformaofd.model;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Класс отображения пользователя
 */
public class User {

    @Id
    private Long id;

    private String login;

    private String password;

    private List<Balance> balanceList;


    public User() {
    }

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(Long id, String login, String password, List<Balance> balanceList) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.balanceList = balanceList;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Balance> getBalanceList() {
        return balanceList;
    }

    public void setBalanceList(List<Balance> balanceList) {
        this.balanceList = balanceList;
    }
}
