package com.example.thi.repository;

import com.example.thi.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<QuestionContent,Long> {
//    Page<QuestionContent> findQuestionContentBy
}
