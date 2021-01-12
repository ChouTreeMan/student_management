package com.niit_team.student_management.Service.impl;

import com.niit_team.student_management.Entity.StudentInfo;
import com.niit_team.student_management.Repository.AdminRepository;
import com.niit_team.student_management.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AdminService")
public class adminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<StudentInfo> getStu_Details() {
        return adminRepository.findAll();
    }

    @Override
    public void addOneStu(StudentInfo studentInfo) {
        adminRepository.save(studentInfo);
    }

    @Override
    public void delOneStu(int stu_id) {
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
    public void ModifyStuDetails(StudentInfo studentInfo) {
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
        adminRepository.updateOneStu(stu_id,name,batch,age,date,bg,addr,phone,email);
    }

}
