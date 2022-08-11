package se.lexicon.course_manager_assignment.data.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager_assignment.data.dao.CourseDao;
import se.lexicon.course_manager_assignment.data.dao.StudentDao;
import se.lexicon.course_manager_assignment.data.service.converter.Converters;
import se.lexicon.course_manager_assignment.dto.forms.CreateStudentForm;
import se.lexicon.course_manager_assignment.dto.forms.UpdateStudentForm;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.Collection;
import java.util.List;

@Service
public class StudentManager implements StudentService {

    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final Converters converters;

    @Autowired
    public StudentManager(StudentDao studentDao, CourseDao courseDao, Converters converters) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.converters = converters;
    }

    @Override
    public StudentView create(CreateStudentForm form) {
        Student student = studentDao.createStudent(form.getName(), form.getEmail(), form.getAddress());
        StudentView view = converters.studentToStudentView(student);
        return view;

    }

    @Override
    public StudentView update(UpdateStudentForm form) {
        Student student = studentDao.createStudent(form.getName(), form.getEmail(), form.getAddress());
        StudentView view = converters.studentToStudentView(student);
//        Student student = studentDao.update(form.getName(), form.getEmail(), form.getAddress());
        return view;
    }

    @Override
    public StudentView findById(int id) {
        Student student = studentDao.findById(id);
        StudentView view = converters.studentToStudentView(student);
        return view;
    }

    @Override
    public StudentView searchByEmail(String email) {
        if (email == null || email.trim().equals("")){
            throw new IllegalArgumentException("It is empty");
        }
        Student student = studentDao.findByEmailIgnoreCase(email);
        StudentView studentView = converters.studentToStudentView(student);
        return studentView;
    }

    @Override
    public List<StudentView> searchByName(String name) {
        if (name == null || name.trim().equals("")){
            throw new IllegalArgumentException("It is empty");
        }
        Collection<Student> student = studentDao.findByNameContains(name);
        List<StudentView> studentViews = converters.studentsToStudentViews(student);
        return studentViews;
    }

    @Override
    public List<StudentView> findAll() {
        Collection<Student> students = studentDao.findAll();
        List<StudentView> studentViews = converters.studentsToStudentViews(students);
        return studentViews;
    }

    @Override
    public boolean deleteStudent(int id) {
        if (id != 0){
            studentDao.removeStudent(studentDao.findById(id));
            return true;
        }
        return false;
    }
}
