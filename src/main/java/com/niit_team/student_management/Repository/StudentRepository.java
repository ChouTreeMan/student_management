package com.niit_team.student_management.Repository;

import com.niit_team.student_management.Entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<StudentInfo,Integer> {
    /*根据与login_id（登录表）对应的name（学生信息表）查询stu_id*/
    @Query(value = "select stu_id from student_details where name = :name", nativeQuery = true)
    int dispatch(@Param("name")String login_id);
    /*学生更新自己个人信息*/
    @Query(value = "update student_details set age=:age," +
            "date_of_birth=:date,blood_group=:bg,address=:addr," +
            "phone_number=:phone,email=:email where stu_id=:stu_id",
            nativeQuery = true)
    @Modifying
    void updateStu(@Param("stu_id")int stu_id,
                      @Param("age")int age,
                      @Param("date")String date,
                      @Param("bg")String bg,
                      @Param("addr")String addr,
                      @Param("phone")String phone,
                      @Param("email")String email);
}
