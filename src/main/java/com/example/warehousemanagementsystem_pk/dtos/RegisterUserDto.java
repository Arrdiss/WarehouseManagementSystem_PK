package com.example.warehousemanagementsystem_pk.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer roleId;
}
