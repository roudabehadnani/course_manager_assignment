package se.lexicon.course_manager_assignment.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    @Test
    public void courseTestName(){
        Course course = new Course(
                "Java",
                LocalDate.of(2022,10,1),
                20);

        assertEquals("Java", course.getCourseName());
    }

    @Test
    public void courseTestStartDate(){
        Course course = new Course(
                "Java",
                LocalDate.of(2022,10,1),
                20);

        assertEquals(LocalDate.of(2022, 10, 1), course.getStartDate());
    }


    @Test
    public void courseTestWeekDuration(){
        Course course = new Course(
                "Java",
                LocalDate.of(2022,10,1),
                20);

        assertEquals(20, course.getWeekDuration());
    }


    @Test
    public void enrollStudentTestIsTrue(){

    }


    @Test
    public void unrollStudentTestIsTrue(){
        Course course = new Course(
                "Java",
                LocalDate.of(2022,10,1),
                20);




    }


}
