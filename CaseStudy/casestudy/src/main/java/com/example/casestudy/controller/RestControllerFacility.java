package com.example.casestudy.controller;

import com.example.casestudy.model.facility.Facility;
import com.example.casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/contracts")
public class RestControllerFacility {
    @Autowired
    private IFacilityService iFacilityService;
    @GetMapping("/search/{id}")
    public ResponseEntity<Facility> findFacilityByFacilityId(@PathVariable Long id) {
        Facility facility = iFacilityService.findFacilityByFacilityId(id);
        if(facility == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(facility,HttpStatus.OK);
    }
}
