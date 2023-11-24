package com.example.casestudy.model.facility;

import com.example.casestudy.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentTypeId;
    private String rentName;
    @JsonBackReference
    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    private Set<Facility> facilitySet;

    public RentType() {
    }

    public long getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(long rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    public Set<Facility> getFacilitySet() {
        return facilitySet;
    }

    public void setFacilitySet(Set<Facility> facilitySet) {
        this.facilitySet = facilitySet;
    }
}