package com.saif.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "DEPARTMENT-SERVICE", decode404 = true)
public interface DepartmentConsumer {
    @GetMapping("/v1/department/api/{departmentId}")
    public ResponseEntity<?> getDepartment(@PathVariable Long departmentId);
}
