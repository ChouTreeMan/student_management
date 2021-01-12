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
public interface AdminRepository extends JpaRepository<StudentInfo, Integer> {
    @Query(value = "update student_details set name=:name,batch=:batch," +
            "age=:age,date_of_birth=:date,blood_group=:bg,address=:addr," +
            "phone_number=:phone,email=:email where stu_id=:stu_id", nativeQuery = true)
    @Modifying
    void updateOneStu(@Param("stu_id")int stu_id,
                      @Param("name")String name,
                      @Param("batch")String batch,
                      @Param("age")int age,
                      @Param("date")String date,
                      @Param("bg")String bg,
                      @Param("addr")String addr,
                      @Param("phone")String phone,
                      @Param("email")String email);
}
