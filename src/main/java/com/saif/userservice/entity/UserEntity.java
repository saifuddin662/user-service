package com.saif.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name = "User_Data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @JsonIgnore
    @Column(name = "sys_user")
    private String sysUser = "Saif";
    @JsonIgnore
    @Column(name = "sys_date")
    private Date sysDate = new Date();
}
