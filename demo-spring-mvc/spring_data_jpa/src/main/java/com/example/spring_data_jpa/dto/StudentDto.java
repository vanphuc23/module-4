package com.example.spring_data_jpa.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class StudentDto implements Validator {
    private int id;
//    @NotBlank(message = "Không được rỗng")
//    @Pattern(regexp = "^[A-Z][a-z]*$",message = "Không đúng định dạng")
    private  String name;
    private  String className;
    private  int gender;
    public StudentDto() {
    }

    public StudentDto(int id,String name, String className, int gender) {
        this.id=id;
        this.name = name;
        this.className = className;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto = (StudentDto)target;
        if(studentDto.getName().isEmpty()) {
            errors.rejectValue("name",null,"Không được để trống");
        } else if(!studentDto.getName().matches("^[A-Z][a-z]*$")) {
            errors.rejectValue("name",null,"Không đúng định dạng");
        }
    }
}
