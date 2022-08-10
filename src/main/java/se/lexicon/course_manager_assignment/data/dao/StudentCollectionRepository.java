package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student student = new Student(name, email, address);
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        for (Student stu: students) {
            if (stu.getEmail().equalsIgnoreCase(email)){
                return stu;
            }
        }
        return null;
    }


    @Override
    public Collection<Student> findByNameContains(String name) {
        List<Student> studentArrayList = new ArrayList<>();
        for (Student stu: students) {
            if (stu.getName().equals(name)){
               studentArrayList.add(stu);
               return studentArrayList;
            }
        }
        return null;
    }


    @Override
    public Student findById(int id) {
        for (Student stu: students) {
            if (stu.getId() == id){
                return stu;
            }
        }
        return null;
    }


    @Override
    public Collection<Student> findAll() {
        return students;
    }


    @Override
    public boolean removeStudent(Student student) {
        for (Student stu: students) {
            if (stu.equals(student)){
                students.remove(student);
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
        
    }
}
