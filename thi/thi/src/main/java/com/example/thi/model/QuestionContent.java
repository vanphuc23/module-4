package com.example.thi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestionContent;
    @Column(columnDefinition = "text")
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    @Column(columnDefinition = "text")
    private String answer;
    @ManyToOne
    @JoinColumn(name = "id_question_type",referencedColumnName = "idQuestionType")
    private QuestionType questionType;
    private LocalDate dateCreate;
    private Integer status;

    public QuestionContent() {
    }

    public Long getIdQuestionContent() {
        return idQuestionContent;
    }

    public void setIdQuestionContent(Long idQuestionContent) {
        this.idQuestionContent = idQuestionContent;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
