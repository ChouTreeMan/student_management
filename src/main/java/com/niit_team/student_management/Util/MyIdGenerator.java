package com.niit_team.student_management.Util;

import com.niit_team.student_management.Entity.StudentInfo;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class MyIdGenerator implements IdentifierGenerator {

    @Autowired
    private StudentInfo studentInfo;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return studentInfo.getStu_id();
    }
}
