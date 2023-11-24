package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPeopleRepository extends JpaRepository<People,Integer> {
    @Query(value = "select count(*) from people where people_id = :peopleId",nativeQuery = true)
    int countByPeopleId(@Param("peopleId")int peopleId);
}
