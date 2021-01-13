package com.niit_team.student_management.Entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "Apply")
public class Apply {
    /*一个学生可以有多个申请，因此在Apply表中stu_id不唯一*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apply_id")
    private int apply_id;
    @Column(name = "stu_id")
    private int stu_id;
    @Column(name = "leave_date")
    private String leave_date;
    @Column(name = "reason")
    @Nullable
    private String reason;

    public Apply(){}

    public Apply(int apply_id, int stu_id, String leave_date, @Nullable String reason) {
        this.apply_id = apply_id;
        this.stu_id = stu_id;
        this.leave_date = leave_date;
        this.reason = reason;
    }

    public int getApply_id() {
        return apply_id;
    }

    public void setApply_id(int apply_id) {
        this.apply_id = apply_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getLeave_date() {
        return leave_date;
    }

    public void setLeave_date(String leave_date) {
        this.leave_date = leave_date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "apply_id:" + apply_id +
                ", stu_id:" + stu_id +
                ", leave_date:'" + leave_date + '\'' +
                ", reason:'" + reason + '\'' +
                '}';
    }
}
