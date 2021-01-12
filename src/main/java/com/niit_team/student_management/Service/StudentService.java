package com.niit_team.student_management.Service;

import com.niit_team.student_management.Entity.StudentInfo;

import javax.servlet.http.HttpServletRequest;

public interface StudentService {
    StudentInfo viewDetail(int stu_id);
    void editDetail(StudentInfo studentInfo);
}
