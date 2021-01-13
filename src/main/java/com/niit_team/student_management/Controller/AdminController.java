package com.niit_team.student_management.Controller;

import com.niit_team.student_management.Entity.StudentInfo;
import com.niit_team.student_management.Service.AdminService;
import com.niit_team.student_management.Service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    /*获取所有学生信息*/
    @GetMapping("/student_details")
    public ModelAndView getAllStudents(){
        ModelAndView mv = new ModelAndView("Administrator");
        mv.addObject("studentList",adminService.getStu_Details());
        return mv;
    }
    /*前往add页面*/
    @RequestMapping("/addDetail")
    public ModelAndView add(){
        return new ModelAndView("Add");
    }

    /*从Add页面提交拿到的数据*/
    @PostMapping("/addOne")
    public ModelAndView addOne(StudentInfo student){
        adminService.addOneStu(student);
        return new ModelAndView("redirect:/Admin/student_details");
    }

    /*删除学生的操作可在student_details页面完成*/
    @RequestMapping("/delOne/{stu_id}")
    public ModelAndView delOne(@PathVariable("stu_id")int stu_id){
        adminService.delOneStu(stu_id);
        return new ModelAndView("redirect:/Admin/student_details");
    }

    /*根据stu_id查询相应记录，前往更新页面*/
    @RequestMapping("/forUpdate/{stu_id}")
    public ModelAndView forUpdate(@PathVariable("stu_id")int stu_id){
        ModelAndView mv = new ModelAndView("UpdateByAdmin");
        mv.addObject("student",adminService.findOneById(stu_id));
        return mv;
    }
    /*保存从update页面拿到的数据，并重定向回admin主页面*/
    @RequestMapping("/update")
    public ModelAndView Update(StudentInfo studentInfo, HttpServletRequest req){
        adminService.ModifyStuDetails(studentInfo,req);
        return new ModelAndView("redirect:/Admin/student_details");
    }

    @Autowired
    private LeaveService leaveService;
    /*获取请假次数表信息*/
    @GetMapping("/leave_info")
    public ModelAndView getLeaveInfo(){
        ModelAndView mv = new ModelAndView("Administrator");
        mv.addObject("leaveList",leaveService.getAllLeaves());
        return mv;
    }
}
