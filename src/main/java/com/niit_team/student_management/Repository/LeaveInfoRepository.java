package com.niit_team.student_management.Repository;

import com.niit_team.student_management.Entity.LeaveInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LeaveInfoRepository extends JpaRepository<LeaveInfo,Integer> {
    /*管理员查询所有学生请假次数信息*/
    /*修改请假次数*/
    @Query(value = "update leave_info set " +
            "leave_taken=leave_taken+1,leave_balance=leave_balance-1",
            nativeQuery = true)
    @Modifying
    void updateApplyTime();
}
