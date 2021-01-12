package com.niit_team.student_management.Repository;

import com.niit_team.student_management.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LoginRepository extends JpaRepository<Account,String> {
    /*检查是否存在此账户*/
    @Query(value="select count(*) from Account WHERE login_id = :login_id and login_password = :login_password",nativeQuery=true)
    int haveOrNot(@Param("login_id")String login_id,@Param("login_password")String login_password);
    /*获取账户类型*/
    @Query(value="select account_type from Account where login_id = :login_id",nativeQuery=true)
    String accountType(@Param("login_id")String login_id);
}
