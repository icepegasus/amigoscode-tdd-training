package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class TestClass {

    private final StudentRepository studentRepository;

    public TestClass(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Transactional(noRollbackFor = RuntimeException.class)
    public void tran() throws RuntimeException, SQLException {

        Student student1 = new Student(
                "Changwoo1",
                "icepega1@gmail.com",
                Gender.MALE
        );

        Student student2 = new Student(
                "Changwoo2",
                "icepega2@gmail.com",
                Gender.MALE
        );

        try {
            studentRepository.save(student1);
            throw new RuntimeException("ERROR");

        } catch (Exception e) {
            System.out.println("e = " + e);
            throw new SQLException(e);
        } finally {
            studentRepository.save(student2);
        }
    }
}
