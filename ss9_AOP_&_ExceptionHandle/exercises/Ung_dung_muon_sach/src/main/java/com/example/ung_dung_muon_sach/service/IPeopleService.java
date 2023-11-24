package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.exception.PersonIdNotExist;
import com.example.ung_dung_muon_sach.model.People;

public interface IPeopleService {
    int createPeopleId();

    boolean updatePeople(People people);

    boolean deletePeople(People people);
    People findPeopleByPeopleId(int peopleId) throws PersonIdNotExist;
}
