package com.saif.userservice.dto;

import com.saif.userservice.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateDto {
    private UserEntity userEntity;
    private DepartmentDto department;
}
