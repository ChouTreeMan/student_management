package com.niit_team.student_management.Repository;

import com.niit_team.student_management.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LoginRepository extends JpaRepository<Account,Integer> {
    /*检查是否存在此账户*/
    @Query(value="select count(*) from Account WHERE login_name = :login_name and login_password = :login_password",nativeQuery=true)
    int haveOrNot(@Param("login_name")String login_name,@Param("login_password")String login_password);
    /*获取账户信息*/
    @Query(value = "select * from account where login_name=:login_name", nativeQuery = true)
    Account getAccountByName(@Param("login_name")String login_name);

    /*获取账户类型*/
    @Query(value="select account_type from Account where login_name = :login_name",nativeQuery=true)
    String accountType(@Param("login_name")String login_name);
    /*修改密码*/
    @Modifying
    @Query(value = "update account set login_password=:pwd where account_id=:account_id", nativeQuery = true)
    void modifyPwd(@Param("account_id")int account_id,@Param("pwd")String pwd);
    /*修改用户名*/
    @Modifying
    @Query(value = "update account set login_name=:login_name where account_id=:account_id", nativeQuery = true)
    void modifyAccountName(@Param("account_id")int account_id,@Param("login_name")String login_name);
}
