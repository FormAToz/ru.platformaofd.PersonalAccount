package ru.platformaofd.model.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс перечислений ролей пользователей
 */
public enum Role {
    USER(Arrays.asList(Permission.USER)),
    ADMIN(Arrays.asList(Permission.USER, Permission.ADMIN));

    private final List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        return permissions.stream()
                .map(p -> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toList());
    }
}
