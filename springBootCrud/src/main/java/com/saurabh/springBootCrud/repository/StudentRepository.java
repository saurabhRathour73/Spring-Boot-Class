package com.saurabh.springBootCrud.repository;

import com.saurabh.springBootCrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface   StudentRepository extends JpaRepository<Student, Long> {

}
