package com.niit_team.student_management.Controller;

import com.niit_team.student_management.Entity.Account;
import com.niit_team.student_management.Exception.StuNullPointerException;
import com.niit_team.student_management.Service.LoginService;
import com.niit_team.student_management.Service.StudentService;
import com.niit_team.student_management.Util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String LoginPage(){
        /*跳转至登录页面*/
        return "index";
    }

    @Autowired
    private LoginService LoginService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/login")
    public ModelAndView checkAccount(Account account, HttpServletRequest req, HttpServletResponse resp){
        ModelAndView mv = new ModelAndView();
        ResultResponse<Object> resultResponse = LoginService.login(account,req,resp);

        /*有此账户且账户类型正确则code=200*/
        if (resultResponse.getCode() == 200){

            if (account.getRole().equals("admin")){
                mv.setViewName("Administrator");
            }else if (account.getRole().equals("stu")){

                if (req.getSession().getAttribute("stu_id")==null){
                    throw new StuNullPointerException("stuId can not be null");
                }
                int stu_id = (int)req.getSession().getAttribute("stu_id");
                mv.addObject("studentInfo",
                        studentService.viewDetail(stu_id));
//            System.out.println("stu_id in checkAccount:"+stu_id);
                mv.setViewName("Students");
            }
        }
        /*未找到账户或账户类型异常*/
        else{
            mv.setViewName("redirect:/");
        }

        return mv;
    }

}
