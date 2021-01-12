package com.niit_team.student_management.Service.impl;

import com.niit_team.student_management.Entity.StudentInfo;
import com.niit_team.student_management.Repository.StudentRepository;
import com.niit_team.student_management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("StuService")
public class studentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentInfo viewDetail(int stu_id) {
        return studentRepository.findById(stu_id).get();
    }

    @Transactional
    @Override
    public void editDetail(StudentInfo studentInfo) {
        int stu_id = studentInfo.getStu_id();
        int age = studentInfo.getAge();
        String date = studentInfo.getDateOfBirth();
        String bg = studentInfo.getBloodGroup();
        String addr = studentInfo.getAddress();
        String phone = studentInfo.getPhoneNumber();
        String email = studentInfo.getEmail();
        studentRepository.updateStu(stu_id,age,date,bg,addr,phone,email);
    }

}
