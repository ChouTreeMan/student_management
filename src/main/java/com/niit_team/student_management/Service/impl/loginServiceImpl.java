package com.niit_team.student_management.Service.impl;

import com.niit_team.student_management.Entity.Account;
import com.niit_team.student_management.Repository.LoginRepository;
import com.niit_team.student_management.Repository.StudentRepository;
import com.niit_team.student_management.Service.LoginService;
import com.niit_team.student_management.Util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service("LoginService")
public class loginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResultResponse<Object> login(Account account, HttpServletRequest req, HttpServletResponse resp) {
        /*若想用Account类接数据
         *页面<input>的属性name必须与Account类里的私有属性名完全对应*/
//        System.out.println("in login:"+account);
        //验证账户是否存在,存在返回1，不存在返回0
        if (loginRepository
                .haveOrNot(account.getLogin_name(),
                account.getPassword())!=1){
                return new ResultResponse<>(404,"account not found");
        }
        //验证账户类型是否正确
        if (loginRepository
                .accountType(account.getLogin_name())
                .equals(account.getRole()) ){
            /*将数据库中账户信息存入request*/
            Account existAccount = loginRepository.getAccountByName(account.getLogin_name());
            req.getSession().setAttribute("Account",existAccount);

            /*当账户类型为学生*/
            if (account.getRole().equals("stu")){
                /*根据与login_id（登录表）对应的name（学生信息表）获取stu_id*/
                int stu_id = studentRepository.dispatch(account.getLogin_name());
//            System.out.println("stu_id in login:"+stu_id);
                req.getSession().setAttribute("stu_id",stu_id);
                req.getSession().setMaxInactiveInterval(600);
            }
            /*返回成功信息*/
            return new ResultResponse<>(200,"success");

        }
        else {return new ResultResponse<>(404,"strange account");}
    }

    @Override
    public void logout(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
    }

    @Override
    public void modifyPwd(HttpServletRequest req, HttpServletResponse resp) {

    }
}
