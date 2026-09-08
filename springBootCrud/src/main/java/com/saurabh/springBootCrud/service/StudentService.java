package com.saurabh.springBootCrud.service;

import com.saurabh.springBootCrud.entity.Student;
import com.saurabh.springBootCrud.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        // business logic
        studentReq.setDeleted(false);
      Student studentResp =   studentRepository.save(studentReq);
      return  studentReq;
    }

    public  Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedFalse(id);

        if (studentResp.isPresent()){
            return  studentResp.get();
        }

        return  null;
    }

    public List<Student> getAllStudent(){
        List<Student> allStudentList = studentRepository.findByDeletedIsFalse();
        return allStudentList;
    }

    public Student updateStudent(Long id , Student student){
        Optional<Student> isStudent = studentRepository.findByIdAndDeletedFalse(id);
        if(isStudent.isEmpty()){
            return  null;
        }
        Student studentToSeve  = isStudent.get();
        studentToSeve.setName(student.getName());
        studentToSeve.setEmail(student.getEmail());
        studentToSeve.setAge(student.getAge());
        studentToSeve.setRollNo(student.getRollNo());
        studentToSeve.setCollageName(student.getCollageName());
        studentToSeve.setSubject(student.getSubject());
        studentToSeve.setDeleted(false);
        return studentRepository.save(studentToSeve);


    }

    public  Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id);
        if (!isStudent){
            return  false;
        }

        studentRepository.deleteById(id);
        return  true;
    }

    public Boolean deleteStudentSoftly(Long id){
        // get record
       Optional<Student> existingStudent=
               studentRepository.findByIdAndDeletedFalse(id);
       if(existingStudent.isEmpty()) return  false;

       Student studentToseve = existingStudent.get();
        // delete = 1
       studentToseve.setDeleted(true);
       studentRepository.save((studentToseve));


        // save
        return true;
    }

    // 1. End point listen (//app/students post)

    // 2. Business logic

    // 3. Interact with DB to store

    // 4 Response back to client

}
