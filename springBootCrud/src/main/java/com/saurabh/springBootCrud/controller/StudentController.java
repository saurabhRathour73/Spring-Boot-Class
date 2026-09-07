package com.saurabh.springBootCrud.controller;

import com.saurabh.springBootCrud.entity.Student;
import com.saurabh.springBootCrud.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // create student  POST-> http://localhost:8080/api/students/create
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent) ;
    }


    // read student all GET ---> http://localhost:8080/api/students/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudetn(){
       List<Student> allStudentList = studentService.getAllStudent();
       if (allStudentList.isEmpty()){
           return ResponseEntity.notFound().build();
       }

       return ResponseEntity.ok(allStudentList);
    }


    // read student GET --> http://localhost:8080/api/students/get/{id}
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){

        Student studentResp= studentService.getStudent(id);

        if (studentResp == null) {
            return  ResponseEntity.notFound().build();
        }

        return  ResponseEntity.status(HttpStatus.OK).body(studentResp);

    }


    // update  PUT ---> http://localhost:8080/api/students/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student studentResp= studentService.updateStudent(id, student);

        if (studentResp == null) {
            return  ResponseEntity.notFound().build();
        }

        return  ResponseEntity.status(HttpStatus.OK).body(studentResp);


    }

    // delete  DELRTR -->http://localhost:8080/api/students/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteStudent(@PathVariable Long id){
     boolean isDeleted =  studentService.deleteStudent(id);
     if(!isDeleted){
         return  ResponseEntity.notFound().build();
     }

     return  ResponseEntity.ok("Record deleted !!");
    }

    // deleted methode softly  // yaha ham patch method ka use karenge maping ke liye
    // soft delete --> PATCH -> /api/students/delete-soft/{id}
   @PatchMapping
   public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
      Boolean isDeleted = studentService.deleteStudentSoftly(id);
      if(!isDeleted){
          return  ResponseEntity.notFound().build();
      }

      return  ResponseEntity.ok("Record deleted softly !! ");
   }
}
