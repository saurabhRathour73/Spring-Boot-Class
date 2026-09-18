package com.example.secondProjectUsingDTO.Validation.service;

import com.example.secondProjectUsingDTO.Validation.DTOs.CreateUserRequestDto;
import com.example.secondProjectUsingDTO.Validation.DTOs.CreateUserResponsDto;
import com.example.secondProjectUsingDTO.Validation.DTOs.GetAllUserDto;
import com.example.secondProjectUsingDTO.Validation.entity.User;
import com.example.secondProjectUsingDTO.Validation.exception.DuplicateResourceException;
import com.example.secondProjectUsingDTO.Validation.exception.ResourceNotFoundException;
import com.example.secondProjectUsingDTO.Validation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }




    public CreateUserResponsDto createUser(CreateUserRequestDto requestDto){
        User userReq = mapToEntity(requestDto);

        if (emailExists(userReq)){
           throw  new DuplicateResourceException("User email "+ userReq.getUserEmail()+" already exist !!");
        }
        User userRes = userRepository.save(userReq);

        return mapToDto(userRes);
    }

    public List<GetAllUserDto> getAllUser(){
       List<User> user = userRepository.findByDeletedFalse();
       return mapToDtoForGet(user);
    }

    public GetAllUserDto getById(Long id){
       User user  = userRepository
                .findByIdAndDeletedFalse(id)
               .orElseThrow(
                        ()-> new ResourceNotFoundException("User Id "+ id + " not found !!"));
       return getByIdDto(user);

    }

    public void userDelete(Long id){
        User user= userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Id "+ id + " not found !!"));
        userRepository.delete(user);
    }

    public void softDelete(Long id){
        User user= userRepository.findByIdAndDeletedFalse(id).orElseThrow(()-> new ResourceNotFoundException("User Id "+ id + " not found !!"));
        user.setDeleted(true);
        userRepository.save(user);

    }






    private CreateUserResponsDto mapToDto(User userRes) {
        CreateUserResponsDto responseDto = new CreateUserResponsDto();
        responseDto.setId(userRes.getId());
        responseDto.setUserName(userRes.getUserName());
        responseDto.setUserEmail(userRes.getUserEmail());
        responseDto.setUserAge(userRes.getUserAge());
        responseDto.setUserCity(userRes.getUserCity());
        responseDto.setMessage("User create successfully !! ");
        responseDto.setCreateAt(userRes.getCreateAt());

        return  responseDto;
    }


    private User mapToEntity(CreateUserRequestDto requestDto){
        User userEntity = new User();
        userEntity.setUserName(requestDto.getUserName());
        userEntity.setUserEmail(requestDto.getUserEmail());
        userEntity.setUserAge(requestDto.getUserAge());
        userEntity.setUserCity(requestDto.getUserCity());
        userEntity.setDeleted(false);
        userEntity.setCreateAt(LocalDateTime.now());
        userEntity.setUpdatedAt(LocalDateTime.now());

        return  userEntity;
    }

    private List<GetAllUserDto> mapToDtoForGet(List<User> users){
        List<GetAllUserDto> userList = new ArrayList<>();
        for (User usrRes : users){
            GetAllUserDto getAllUserDto = new GetAllUserDto();
            getAllUserDto.setUserName(usrRes.getUserName());
            getAllUserDto.setUserEmail(usrRes.getUserEmail());
            getAllUserDto.setUserCity(usrRes.getUserCity());
            getAllUserDto.setUserAge(usrRes.getUserAge());
            getAllUserDto.setId(usrRes.getId());
            getAllUserDto.setUpdatedAt(usrRes.getUpdatedAt());
            getAllUserDto.setMessage("user fetch Successfully !!");
            userList.add(getAllUserDto);
        }
        return userList;
    }

    private GetAllUserDto getByIdDto(User usrRes){

        GetAllUserDto getAllUserDto = new GetAllUserDto();
        getAllUserDto.setUserName(usrRes.getUserName());
        getAllUserDto.setUserEmail(usrRes.getUserEmail());
        getAllUserDto.setUserCity(usrRes.getUserCity());
        getAllUserDto.setUserAge(usrRes.getUserAge());
        getAllUserDto.setId(usrRes.getId());
        getAllUserDto.setUpdatedAt(usrRes.getUpdatedAt());
        getAllUserDto.setMessage("user fetch Successfully !!");
        return getAllUserDto;
    }

    private boolean emailExists(User user){
        // real application me e nhi kr sakte haii
      return   userRepository.existsByuserEmail(user.getUserEmail());
    }
}
