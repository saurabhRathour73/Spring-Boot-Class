package com.example.secondProjectUsingDTO.Validation.controller;

import com.example.secondProjectUsingDTO.Validation.DTOs.CreateUserRequestDto;
import com.example.secondProjectUsingDTO.Validation.DTOs.CreateUserResponsDto;
import com.example.secondProjectUsingDTO.Validation.DTOs.GetAllUserDto;
import com.example.secondProjectUsingDTO.Validation.entity.User;
import com.example.secondProjectUsingDTO.Validation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private  UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponsDto> createUser(@Valid @RequestBody CreateUserRequestDto userRequestDto){

        CreateUserResponsDto responseDto = userService.createUser(userRequestDto);

        return  ResponseEntity.status(201).body(responseDto);

    }

    @GetMapping
    public ResponseEntity<List<GetAllUserDto>> getAllUser(){
        List<GetAllUserDto> getAllUserDtos = userService.getAllUser();
        return ResponseEntity.status(200).body(getAllUserDtos);
    }

    @GetMapping("/{id}")

    public ResponseEntity<GetAllUserDto> getUserById(@PathVariable Long id ){
        GetAllUserDto getAllUserDto = userService.getById(id);

        return ResponseEntity.status(200).body(getAllUserDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.userDelete(id);
        return ResponseEntity.status(204).body("Record Deleted !!");
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<String> userSoftDelete(@PathVariable Long id){
        userService.softDelete(id);
        return ResponseEntity.status(200).body("Record Deleted !!");
    }



}
