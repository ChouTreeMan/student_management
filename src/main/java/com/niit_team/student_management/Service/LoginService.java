package com.niit_team.student_management.Service;

import com.niit_team.student_management.Entity.Account;
import com.niit_team.student_management.Util.ResultResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    ResultResponse<Object> login(Account account, HttpServletRequest req, HttpServletResponse resp);
    void logout(HttpServletRequest req,HttpServletResponse resp);
    void modifyPwd(HttpServletRequest req,HttpServletResponse resp);
}
