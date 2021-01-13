package com.niit_team.student_management.Controller;

import com.niit_team.student_management.Entity.Apply;
import com.niit_team.student_management.Entity.StudentInfo;
import com.niit_team.student_management.Exception.StuNullPointerException;
import com.niit_team.student_management.Service.LeaveService;
import com.niit_team.student_management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getDetail")
    public ModelAndView viewOneDetail(HttpServletRequest req){
        ModelAndView mv = new ModelAndView("Students");

        if (req.getSession().getAttribute("stu_id")==null){
            throw new StuNullPointerException("stuId can not be null");
        }
        int stu_id = (int)req.getSession().getAttribute("stu_id");
        StudentInfo studentInfo = studentService.viewDetail(stu_id);
        mv.addObject("studentInfo",studentInfo);
        return mv;
    }

    @PostMapping("/editOne")
    public ModelAndView editOne(StudentInfo studentInfo){
        studentService.editDetail(studentInfo);
        return new ModelAndView("redirect:/Stu/getDetail");
    }

    @Autowired
    private LeaveService leaveService;
    /*获取自己提交过的申请*/
    @GetMapping("/getMyLeaves")
    public ModelAndView getMyLeave(HttpServletRequest req){
        ModelAndView mv = new ModelAndView("Students");

        if (req.getSession().getAttribute("stu_id")==null){
            throw new StuNullPointerException("stuId can not be null");
        }
        int stu_id = (int)req.getSession().getAttribute("stu_id");
        List<Apply> applies = leaveService.getApplyById(stu_id);
        mv.addObject("MyApply",applies);
        return mv;
    }


    @RequestMapping("/apply")
    public ModelAndView applyPage(HttpServletRequest req){
        ModelAndView mv = new ModelAndView("Apply");

        if (req.getSession().getAttribute("stu_id")==null){
            throw new StuNullPointerException("stuId can not be null");
        }
        int stu_id = (int)req.getSession().getAttribute("stu_id");
        mv.addObject("stuId",stu_id);
        return mv;
    }

    @PostMapping("/applyForLeave")
    public ModelAndView applyForLeave(Apply apply){
        leaveService.apply(apply);
        return new ModelAndView("redirect:/Stu/getDetail");
    }
}
