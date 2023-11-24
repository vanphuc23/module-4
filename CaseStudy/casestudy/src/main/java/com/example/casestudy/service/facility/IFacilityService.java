package com.example.casestudy.service.facility;

import com.example.casestudy.model.facility.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> listFacility();
    void save(Facility facility);
    Facility findFacilityByFacilityId(Long facilityId);
    void deleteFacility(Facility facility);
}
