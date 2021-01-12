package com.niit_team.student_management;

import com.niit_team.student_management.Service.AdminService;
import com.niit_team.student_management.Service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudentManagementApplication.class)
class StudentManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private LoginService loginService;

    @Test
    void test1(){

    }

}
