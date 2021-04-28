package ru.platformaofd.model;

import java.util.List;

/**
 * Класс отображения пользователя
 */
public class User {

    private String login;
    private String password;
    private List<Balance> balanceList;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, List<Balance> balanceList) {
        this.login = login;
        this.password = password;
        this.balanceList = balanceList;
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
