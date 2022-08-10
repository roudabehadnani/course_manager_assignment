package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        Course course = new Course(courseName, startDate, weekDuration);
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course c: courses) {
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }


    @Override
    public Collection<Course> findByNameContains(String name) {
        List<Course> courses1 = new ArrayList<>();
        for (Course c: courses) {
            if (c.getCourseName().contains(name)){
                courses1.add(c);
                return courses1;
            }
        }
        return null;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        List<Course> courses1 = new ArrayList<>();
        for (Course c: courses) {
            if (c.getStartDate().plusWeeks(c.getWeekDuration()).isBefore(end)){
                courses1.add(c);
                return courses1;
            }
        }
        return null;
    }


    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        List<Course> courses1 = new ArrayList<>();
        for (Course c: courses) {
            if (c.getStartDate().isAfter(start)){
                courses1.add(c);
                return courses1;
            }
        }
        return null;
    }


    @Override
    public Collection<Course> findAll() {
        return courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        //todo:must be check
        List<Course> courses1 = new ArrayList<>();
        for (Course c: courses) {
            if (c.getId() == studentId){
                courses1.add(c);
                return courses1;
            }
        }
        return null;
    }


    @Override
    public boolean removeCourse(Course course) {
        for (Course c: courses) {
            if (c.equals(course)){
                courses.remove(course);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}
