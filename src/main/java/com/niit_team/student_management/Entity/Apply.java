package com.niit_team.student_management.Entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Apply")
public class Apply {
    /*一个学生可以有多个申请，因此在Apply表中stu_id不唯一*/
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stu_id")
    private String stu_id;
    @Column(name = "leave_date")
    private Date leave_date;
    @Column(name = "reason")
    @Nullable
    private String reason;

    public Apply(){}

    public Apply(String stu_id, Date leave_date, String reason) {
        this.stu_id = stu_id;
        this.leave_date = leave_date;
        this.reason = reason;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public Date getLeave_date() {
        return leave_date;
    }

    public void setLeave_date(Date leave_date) {
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
                "stu_id:'" + stu_id + '\'' +
                ", leave_date:" + leave_date +
                ", reason:'" + reason + '\'' +
                '}';
    }
}
