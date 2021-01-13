package com.niit_team.student_management.Service;

import com.niit_team.student_management.Entity.StudentInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdminService {
    List<StudentInfo> getStu_Details();
    void addOneStu(StudentInfo studentInfo);
    void delOneStu(int stu_id);
    StudentInfo findOneById(int stu_id);
    void ModifyStuDetails(StudentInfo studentInfo,HttpServletRequest req);
}
