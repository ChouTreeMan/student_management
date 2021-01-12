package com.niit_team.student_management.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private String login_id;    //学生姓名登录，与学生信息表的name对应
    @Column(name = "login_password")
    private String password;
    @Column(name = "account_type")
    private String role;

    public Account(){}

    public Account(String login_id, String password, String role) {
        this.login_id = login_id;
        this.password = password;
        this.role = role;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String id) {
        this.login_id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String accountType) {
        this.role = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login_id:'" + login_id + '\'' +
                ", password:'" + password + '\'' +
                ", accountType:'" + role + '\'' +
                '}';
    }
}
