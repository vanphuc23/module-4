package com.example.thi.controller;

import com.example.thi.dto.QuestionContentDto;
import com.example.thi.model.QuestionContent;
import com.example.thi.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/questions")
public class QuestionRestController {
    @Autowired
    private IQuestionService iQuestionService;

    @GetMapping("/{id}")
    public ResponseEntity<QuestionContent> showQuestionFindById(@PathVariable Long id) {
        QuestionContent questionContent = iQuestionService.findById(id);
        if (questionContent == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(questionContent, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<QuestionContent>> showList() {
        List<QuestionContent> list = iQuestionService.findAll();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody QuestionContent questionContent) {
        if(questionContent == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iQuestionService.save(questionContent);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> edit(@RequestBody QuestionContent questionContent) {
        QuestionContent questionContent1 = iQuestionService.findById(questionContent.getIdQuestionContent());
        if(questionContent1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iQuestionService.save(questionContent1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        QuestionContent questionContent = iQuestionService.findById(id);
        if(questionContent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iQuestionService.delete(questionContent);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
