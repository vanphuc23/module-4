package com.example.casestudy.service.facility;

import com.example.casestudy.model.facility.FacilityType;
import com.example.casestudy.repository.facility.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService{
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;

    @Override
    public List<FacilityType> facilityTypeList() {
        return iFacilityTypeRepository.findAll();
    }

    @Override
    public FacilityType findById(Long id) {
        return iFacilityTypeRepository.findById(id).orElse(null);
    }

}
