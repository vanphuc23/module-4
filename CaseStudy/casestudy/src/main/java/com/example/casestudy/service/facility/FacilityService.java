package com.example.casestudy.service.facility;

import com.example.casestudy.model.facility.Facility;
import com.example.casestudy.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService{
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public List<Facility> listFacility() {
        return iFacilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Facility findFacilityByFacilityId(Long facilityId) {
        return iFacilityRepository.findById(facilityId).orElse(null);
    }

    @Override
    public void deleteFacility(Facility facility) {
        iFacilityRepository.delete(facility);
    }
}
