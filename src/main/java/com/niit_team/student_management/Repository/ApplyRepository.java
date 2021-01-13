package com.niit_team.student_management.Repository;

import com.niit_team.student_management.Entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ApplyRepository extends JpaRepository<Apply,Integer> {
    /*保存请假申请*/
    @Modifying
    @Query(value = "insert into apply values (null,:stu_id,:leave_date,:reason)", nativeQuery = true)
    void saveApply(@Param("stu_id")int stu_id,
                   @Param("leave_date")String date,
                   @Param("reason")String reason);
    /*学生查询自己提交的请假申请*/
    @Query(value = "select * from Apply where stu_id=:stu_id",nativeQuery = true)
    List<Apply> getMyApplies(@Param("stu_id")int stu_id);
}
