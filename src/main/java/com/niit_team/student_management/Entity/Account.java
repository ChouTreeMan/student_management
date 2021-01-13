package com.niit_team.student_management.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private int account_id;
    @Column(name = "login_name")
    private String login_name;    //学生姓名登录，与学生信息表的name对应
    @Column(name = "login_password")
    private String password;
    @Column(name = "account_type")
    private String role;

    public Account(){}

    public Account(String login_name, String password, String role) {
        this.login_name = login_name;
        this.password = password;
        this.role = role;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String id) {
        this.login_name = id;
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
                "account_id:" + account_id +
                ", login_name:'" + login_name + '\'' +
                ", password:'" + password + '\'' +
                ", role:'" + role + '\'' +
                '}';
    }
}
