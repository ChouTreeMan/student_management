package com.niit_team.student_management.Service.impl;

import com.niit_team.student_management.Entity.Apply;
import com.niit_team.student_management.Entity.LeaveInfo;
import com.niit_team.student_management.Repository.ApplyRepository;
import com.niit_team.student_management.Repository.LeaveInfoRepository;
import com.niit_team.student_management.Service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LeaveService")
public class leaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveInfoRepository leaveRepository;
    /*管理*/
    @Override
    public List<LeaveInfo> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Autowired
    private ApplyRepository applyRepository;
    /*学生*/
    @Override
    public List<Apply> getApplyById(int stu_id) {
        return applyRepository.getMyApplies(stu_id);
    }

    @Override
    public void apply(Apply apply) {
        /*保存请假申请*/
        applyRepository.save(apply);
        /*修改请假次数信息*/
//        leaveRepository.updateApplyTime();
    }
}
