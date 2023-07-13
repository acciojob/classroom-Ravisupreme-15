package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

      // student map
    HashMap<String,Student> studentHashMap  = new HashMap<>();

    // teacher map

    HashMap<String,Teacher> teacherHashMap = new HashMap<>();

    // student- teacher pair

    HashMap<String, List<String>> studentTeacher = new HashMap<>();





    public void addStudent(Student student) {




         studentHashMap.put(student.getName(),student);


    }


    public void addTeacher(Teacher teacher) {



           teacherHashMap.put(teacher.getName(),teacher);

    }

    public void addStudentTeacherpair(String student, String teacher) {


              List<String> list= new ArrayList<>();

              if(studentTeacher.containsKey(teacher)) list = studentTeacher.get(teacher);

               list.add(student);

               studentTeacher.put(teacher,list);

    }

    public Student getStudentByName(String name) {


            if(studentHashMap.containsKey(name)) return studentHashMap.get(name);

            return null;
    }

    public Teacher getTeacherByName(String name) {

           if(teacherHashMap.containsKey(name)) return teacherHashMap.get(name);

           return null;
    }

    public List<String> getStudets(String teacher) {


           List<String> studentList = new ArrayList<>();

           if(studentTeacher.containsKey(teacher)) studentList = studentTeacher.get(teacher);


           return studentList;

    }

    public List<String> getAllStudents() {

          List<String> studentList = new ArrayList<>();

          for(String key:studentHashMap.keySet()){

                  studentList.add(key);
          }

          return studentList;
    }

    public void deleteTeacherByName(String teacher) {

           teacherHashMap.remove(teacher);

          List<String> studentslist = studentTeacher.get(teacher);

          studentTeacher.remove(teacher);

          for(String student: studentslist){

               studentHashMap.remove(student);
          }


    }

    public void deleteAllTeachers() {



            for(String teacher: studentTeacher.keySet()){

                  List<String> studentList = studentTeacher.get(teacher);

                  studentTeacher.remove(teacher);
                  teacherHashMap.remove(teacher);

                  for(String student : studentList){

                      studentHashMap.remove(student);
                  }
            }
    }
}
