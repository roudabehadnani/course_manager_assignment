package se.lexicon.course_manager_assignment.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ModelToDto implements Converters {

    @Override
    public StudentView studentToStudentView(Student student) {
        StudentView studentView =  new StudentView(student.getId(),
                student.getName(),student.getEmail(),student.getAddress());
        return studentView;
    }

    @Override
    public CourseView courseToCourseView(Course course) {
        CourseView courseView = new CourseView(course.getId(), course.getCourseName(), course.getStartDate(),
                course.getWeekDuration(),new ArrayList<>());
        return courseView;
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
        List<CourseView> courseViews = new ArrayList<>();
        for (Course c: courses) {
            CourseView cView = courseToCourseView(c);
            courseViews.add(cView);
        }
        return courseViews;
    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {
        //step1: create an empty list of view
        //step2: travers on input list
        //step3: get the element of input list
        //step4: convert element to view through the defined method
        //step5: add the converted data to output list
        //step6: return the result
        List<StudentView> studentViews = new ArrayList<>();
        for (Student element: students) {
           StudentView view = studentToStudentView(element);
           studentViews.add(view);
        }
        return studentViews;
    }
}
