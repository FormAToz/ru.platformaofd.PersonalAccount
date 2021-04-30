package ru.platformaofd.model;

import org.springframework.data.annotation.Id;
import ru.platformaofd.model.enums.Role;

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
    private Role role;

    public User() {
    }

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(Long id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(Long id, String login, String password, List<Balance> balanceList, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.balanceList = balanceList;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
