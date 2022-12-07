package com.example.Happireshipi.dao;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @Column(nullable = false, length = 150)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String login;

    @Column(nullable = false, length = 150)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {}

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
}
