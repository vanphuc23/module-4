package com.example.thi.service;

import com.example.thi.model.QuestionType;
import com.example.thi.repository.IQuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService{
    @Autowired
    private IQuestionTypeRepository iQuestionTypeRepository;

    @Override
    public List<QuestionType> listQuestionType() {
        return iQuestionTypeRepository.findAll();
    }
}
