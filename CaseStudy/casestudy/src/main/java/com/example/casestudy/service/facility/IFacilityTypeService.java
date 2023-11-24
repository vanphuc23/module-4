package com.example.casestudy.service.facility;

import com.example.casestudy.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> facilityTypeList();
    FacilityType findById(Long id);
}
