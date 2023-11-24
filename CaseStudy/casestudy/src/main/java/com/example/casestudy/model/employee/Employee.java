package com.example.casestudy.model.employee;

import com.example.casestudy.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotNull
    private String employeeName;
    @Column(name = "date_of_birth")
    @NotNull
    private LocalDate birthday;
    @Column(name = "id_card")
    @NotNull
    private String cmnd;
    @NotNull
    private String phone;
    private String email;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "education_degree_id", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "position_id",referencedColumnName = "positionId")
    private Position position;
    @NotNull
    private double salary;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "division_id",referencedColumnName = "divisionId")
    private Division division;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Contract> contractList;
    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getDate() {
        return birthday;
    }

    public void setDate(LocalDate date) {
        this.birthday = date;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
