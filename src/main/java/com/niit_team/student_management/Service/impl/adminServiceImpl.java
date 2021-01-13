package com.niit_team.student_management.Service.impl;

import com.niit_team.student_management.Entity.Account;
import com.niit_team.student_management.Entity.LeaveInfo;
import com.niit_team.student_management.Entity.StudentInfo;
import com.niit_team.student_management.Repository.AdminRepository;
import com.niit_team.student_management.Repository.LeaveInfoRepository;
import com.niit_team.student_management.Repository.LoginRepository;
import com.niit_team.student_management.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("AdminService")
public class adminServiceImpl implements AdminService {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private LeaveInfoRepository leaveInfoRepository;


    @Override
    public List<StudentInfo> getStu_Details() {
        return adminRepository.findAll();
    }

    @Override
    public void addOneStu(StudentInfo studentInfo) {
        /*往学生信息表添加学生*/
        adminRepository.save(studentInfo);
        /*往账户信息表添加账户*/
        Account account = new Account();
        account.setLogin_name(studentInfo.getName());
        account.setPassword("12345");
        account.setRole("stu");
        loginRepository.save(account);
        /*初始化请假次数表中的信息*/
        LeaveInfo leaveInfo = new LeaveInfo(
                studentInfo.getStu_id(),
                0,
                10
        );
        leaveInfoRepository.save(leaveInfo);
    }

    @Override
    public void delOneStu(int stu_id) {
        /*从学生信息表删除信息，并级联删除apply、leave_info表中信息*/
        adminRepository.deleteById(stu_id);

    }
    /*根据stu_id获取将被修改学生的原始信息*/
    @Override
    public StudentInfo findOneById(int stu_id) {
        return adminRepository.findById(stu_id).get();
    }
    /*获取到修改后的学生信息,存入数据库*/
    @Transactional
    @Override
    public void ModifyStuDetails(StudentInfo studentInfo, HttpServletRequest req) {
        int stu_id = studentInfo.getStu_id();
        String name = studentInfo.getName();
        String batch = studentInfo.getBatch();
        int age = studentInfo.getAge();
        String date = studentInfo.getDateOfBirth();
        String bg = studentInfo.getBloodGroup();
        String addr = studentInfo.getAddress();
        String phone = studentInfo.getPhoneNumber();
        String email = studentInfo.getEmail();
//        System.out.println("stu_id in MSD:"+stu_id);
        /*从学生信息表修改学生信息*/
        adminRepository.updateOneStu(stu_id,name,batch,age,date,bg,addr,phone,email);
    }

}
