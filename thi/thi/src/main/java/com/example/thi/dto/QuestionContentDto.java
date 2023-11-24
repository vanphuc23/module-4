package com.example.thi.dto;

import com.example.thi.model.QuestionType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class QuestionContentDto implements Validator {
    private String title;
    private String content;
    private QuestionType questionType;

    public QuestionContentDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        QuestionContentDto questionContentDto = (QuestionContentDto) target;
        if (questionContentDto.getTitle().isEmpty()) {
            errors.rejectValue("title", null, "Không được để trống");
        } else if (questionContentDto.getTitle().length() < 5 || questionContentDto.getTitle().length() > 100) {
            errors.rejectValue("title", null, "Tiêu đề phải từ 5 đến 100 ký tự");
        }
        if (questionContentDto.getContent().isEmpty()) {
            errors.rejectValue("content", null, "Không được để trống");
        } else if (questionContentDto.getContent().length() < 10 || questionContentDto.getContent().length() > 500) {
            errors.rejectValue("content", null, "Tiêu đề phải từ 10 đến 500 ký tự");
        }

    }
}
