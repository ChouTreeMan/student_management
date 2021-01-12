package com.niit_team.student_management.Entity;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "Student_Details")
public class StudentInfo {
    @Id
    @TableGenerator(name = "MyGenerator", initialValue = 10001)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "MyGenerator")
    @Column(name = "stu_id")
    private int stu_id;
    @Column(name = "name")
    private String name;
    @Column(name = "batch")
    private String batch;           //组别
    @Column(name = "age")
    private int age;
    @Column(name = "date_of_birth")
    @Nullable
    private String DateOfBirth;     //出生日期
    @Column(name = "blood_group")
    @Nullable
    private String BloodGroup;      //血型
    @Column(name = "address")
    @Nullable
    private String address;
    @Column(name = "phone_number")
    @Nullable
    private String phoneNumber;
    @Column(name = "email")
    @Nullable
    private String email;

    public StudentInfo() {}

    public StudentInfo(int stu_id, String name, String batch, int age,
                       String dateOfBirth, String bloodGroup, String address,
                       String phoneNumber, String email) {
        super();
        this.stu_id = stu_id;
        this.name = name;
        this.batch = batch;
        this.age = age;
        DateOfBirth = dateOfBirth;
        BloodGroup = bloodGroup;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
//        DateOfBirth = new SimpleDateFormat("yyyy-MM-dd")
//                .format(dateOfBirth);
        DateOfBirth = dateOfBirth;

    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
