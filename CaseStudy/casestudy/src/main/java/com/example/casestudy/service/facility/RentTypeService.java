package com.example.casestudy.service.facility;

import com.example.casestudy.model.facility.RentType;
import com.example.casestudy.repository.facility.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService{
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> rentTypeList() {
        return iRentTypeRepository.findAll();
    }
}
