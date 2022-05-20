package com.saif.userservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saif.userservice.dto.ResponseTemplateDto;
import com.saif.userservice.entity.UserEntity;
import com.saif.userservice.feign.DepartmentConsumer;
import com.saif.userservice.repository.UserRepository;
import com.saif.userservice.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentConsumer departmentConsumer;

    public ResponseEntity<?> saveUser(UserEntity userEntity) {
        try {
            userRepository.save(userEntity);
            return ResponseEntity.status(HttpStatus.OK).body("Save Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
        }
    }

    public ResponseEntity<?> getUserWithDepartment(Long userId) {
        try {
            UserEntity userEntity = userRepository.findById(userId).get();
            ResponseEntity<?> a = departmentConsumer.getDepartment(userEntity.getDepartmentId());
            Object o = a.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            DepartmentDto department = objectMapper.convertValue(o, DepartmentDto.class);
            ResponseTemplateDto responseTemplateDto = new ResponseTemplateDto();
            responseTemplateDto.setUserEntity(userEntity);
            responseTemplateDto.setDepartment(department);
            return ResponseEntity.status(HttpStatus.OK).body(responseTemplateDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
        }
    }
}
