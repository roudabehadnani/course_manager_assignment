package se.lexicon.course_manager_assignment.model;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    @Test
    public void studentTestName(){

        Student student = new Student(
                "Roudabeh Ad",
                "rod@mail.com",
                "Karlskrona,Minervavagen 20"
        );

        String expected = "Roudabeh Ad";
        String actual = student.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void studentTestEmail(){

        Student student = new Student(
                "Roudabeh Ad",
                "rod@mail.com",
                "Karlskrona,Minervavagen 20"
        );

        String expected = "rod@mail.com";
        String actual = student.getEmail();
        assertEquals(expected, actual);
    }

    @Test
    public void studentTestAddress(){

        Student student = new Student(
                "Roudabeh Ad",
                "rod@mail.com",
                "Karlskrona,Minervavagen 20"
        );

        String expected = "Karlskrona,Minervavagen 20";
        String actual = student.getAddress();
        assertEquals(expected, actual);
    }

    @Test
    public void studentTestId(){

        Student student = new Student(
                "Roudabeh Ad",
                "rod@mail.com",
                "Karlskrona,Minervavagen 20"
        );

        int expected = StudentSequencer.getStudentSequencer();
        int actual = student.getId();

        assertEquals(expected, actual);
    }


}
