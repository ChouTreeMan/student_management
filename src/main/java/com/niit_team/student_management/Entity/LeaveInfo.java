package com.niit_team.student_management.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Leave_Info")
public class LeaveInfo {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stu_id")
    private int stu_id;
    /*管理可查阅的*/
    @Column(name = "leave_taken")
    private int leave_taken;
    @Column(name = "leave_balance")
    private int leave_balance;
    /*学生提交的*/


    public LeaveInfo(){}

    public LeaveInfo(int stu_id, int leave_taken, int leave_balance) {
        this.stu_id = stu_id;
        this.leave_taken = leave_taken;
        this.leave_balance = leave_balance;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getLeave_taken() {
        return leave_taken;
    }

    public void setLeave_taken(int leave_taken) {
        this.leave_taken = leave_taken;
    }

    public int getLeave_balance() {
        return leave_balance;
    }

    public void setLeave_balance(int leave_balance) {
        this.leave_balance = leave_balance;
    }

    @Override
    public String toString() {
        return "LeaveInfo{" +
                "stu_id:" + stu_id +
                ", leave_taken:" + leave_taken +
                ", leave_balance:" + leave_balance +
                '}';
    }
}
