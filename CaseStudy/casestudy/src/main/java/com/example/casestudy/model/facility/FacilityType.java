package com.example.casestudy.model.facility;

import com.example.casestudy.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facilityTypeId;
    private String facilityTypeName;
    @JsonBackReference
    @OneToMany(mappedBy = "facilityType",cascade = CascadeType.ALL)
    private Set<Facility> facilitySet;

    public FacilityType() {
    }

    public long getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(long facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }

    public Set<Facility> getFacilitySet() {
        return facilitySet;
    }

    public void setFacilitySet(Set<Facility> facilitySet) {
        this.facilitySet = facilitySet;
    }
}
