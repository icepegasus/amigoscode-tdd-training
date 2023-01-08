package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShoudselectEmailExists() {

        //given
        String email = "icepega@gmail.com";
        Student student = new Student(
                "Changwoo",
                email,
                Gender.MALE
        );
        underTest.save(student);

        //when
        boolean expected = underTest.selectExistsEmail(email);
        //then
        assertThat(expected).isTrue();
    }

    @Test
    void itShoudselectEmailNotExists() {

        //given
        String email = "icepega@gmail.com";

        //when
        boolean expected = underTest.selectExistsEmail(email);
        //then
        assertThat(expected).isFalse();
    }
}