package com.example.demo_webservice.controller;

import com.example.demo_webservice.model.Student;
import com.example.demo_webservice.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/student")
public class RestControllerStudent {
    @Autowired
    private IStudentService iStudentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> showStudentList() {
        List<Student> studentList = iStudentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);//200
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Student student) {
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);//400
        }
        iStudentService.save(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<Student>> pageStudent(@RequestParam(defaultValue = "0", required = false) int page) {
        Pageable pageable = PageRequest.of(page,1);
        Page<Student> studentPage = iStudentService.findAll(pageable);
        if(studentPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>( studentPage,HttpStatus.OK);//200
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Student student = iStudentService.findById(id);
        if(student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iStudentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody Student student) {
        Student student1 = iStudentService.findById(student.getId());
        if(student1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iStudentService.save(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
