package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepostiory = new StudentRepository();

    public void addStudent(Student student) {

        studentRepostiory.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {

        studentRepostiory.addTeacher(teacher);
    }

    public void addStudentTeacherpair(String student, String teacher) {


        studentRepostiory.addStudentTeacherpair(student,teacher);
    }

    public Student getStudentByName(String name) {

        return studentRepostiory.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name) {

        return studentRepostiory.getTeacherByName(name);
    }

    public List<String> getStudents(String teacher) {

        return studentRepostiory.getStudets(teacher);
    }

    public List<String> getAllStudents() {

        return studentRepostiory.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {


          studentRepostiory.deleteTeacherByName(teacher);

    }

    public void deleteAllTeachers() {

         studentRepostiory.deleteAllTeachers();
    }
}
