package com.niit_team.student_management.Service;

import com.niit_team.student_management.Entity.Apply;
import com.niit_team.student_management.Entity.LeaveInfo;

import java.util.List;

public interface LeaveService {
    List<LeaveInfo> getAllLeaves();
    List<Apply> getApplyById(int stu_id);
    void apply(Apply apply);
}
