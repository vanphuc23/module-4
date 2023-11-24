package com.example.thi.repository;

import com.example.thi.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType,Long> {
}
