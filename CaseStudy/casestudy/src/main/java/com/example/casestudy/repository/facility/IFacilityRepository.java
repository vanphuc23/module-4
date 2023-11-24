package com.example.casestudy.repository.facility;

import com.example.casestudy.model.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Long> {
}
