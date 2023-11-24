package com.example.casestudy.model.facility;

import com.example.casestudy.model.contract.Contract;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facilityId;
    @NotNull
    @Column(name = "facility_name")
    private String facilityName;
    private String area;
    @NumberFormat(pattern = "#,###.###")
    private Long cost;
    @Column(name = "max_people")
    private Integer maxPeople;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rentTypeId")
    private RentType rentType;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "facility_type_id",referencedColumnName = "facilityTypeId")
    private FacilityType facilityType;
    @Column(name = "standard_room")
    private String standardRoom;
    @Column(name = "description_other_convenience")
    private String descriptionOtherConvenience;
    @Column(name = "pool_area")
    private String poolArea;
    @Column(name = "number_of_floors")
    private Integer numberOfFloors;
    @Column(name = "facility_free", columnDefinition = "text")
    private String facilityFree;
    @OneToMany(mappedBy = "facility",cascade = CascadeType.ALL)
    private List<Contract> contractList;
    public Facility() {
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }
}
