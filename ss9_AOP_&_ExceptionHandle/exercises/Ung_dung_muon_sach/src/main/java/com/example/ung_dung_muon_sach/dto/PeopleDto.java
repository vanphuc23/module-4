package com.example.ung_dung_muon_sach.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PeopleDto implements Validator {
    private String peopleId;
    private String nameOfBook;

    public PeopleDto() {
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PeopleDto peopleDto = (PeopleDto) target;
        if(!peopleDto.getPeopleId().matches("^[0-9]{5}$")) {
            errors.rejectValue("peopleId",null,"Không đúng định dạng");
        }else if(peopleDto.getPeopleId().length()>5) {
            errors.rejectValue("peopleId",null,"Mã không được quá 5 số");
        }
    }
}
