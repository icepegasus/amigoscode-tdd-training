package com.example.demo.student;

import com.example.demo.DemoApplication;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = DemoApplication.class)
public class TransactionTest {

    @Autowired
    private TestClass testClass;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void test() throws Exception{

        try {
            testClass.tran();
        }catch (Exception e){
            System.out.println("CATCH");
        }



        //assertThat(isStudunt1Exist).isTrue();
        //assertThat(isStudunt2Exist).isTrue();

    }



    @AfterEach
    void tearDown() {

        //then
        Boolean isStudunt1Exist = studentRepository.selectExistsEmail("icepega1@gmail.com");
        Boolean isStudunt2Exist = studentRepository.selectExistsEmail("icepega2@gmail.com");

        System.out.println("isStudunt1Exist = " + isStudunt1Exist);
        System.out.println("isStudunt2Exist = " + isStudunt2Exist);

    }

}
