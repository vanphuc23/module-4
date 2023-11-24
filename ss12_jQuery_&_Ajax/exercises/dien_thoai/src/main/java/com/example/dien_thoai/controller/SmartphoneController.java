package com.example.dien_thoai.controller;

import com.example.dien_thoai.model.Smartphone;
import com.example.dien_thoai.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin("/")
@RequestMapping("/api/smartphone")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService iSmartphoneService;
    @PostMapping("/create")
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(iSmartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("")
    public ResponseEntity<List<Smartphone>> allPhones() {
        return new ResponseEntity<>(iSmartphoneService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Smartphone smartphone = iSmartphoneService.findById(id);
        if(smartphone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSmartphoneService.remove(smartphone);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> findByIdUpdate(@PathVariable long id) {
        Smartphone smartphone = iSmartphoneService.findById(id);
        if(smartphone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }
    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody Smartphone smartphone) {
        iSmartphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
