package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.exception.PersonIdNotExist;
import com.example.ung_dung_muon_sach.model.People;
import com.example.ung_dung_muon_sach.repository.IPeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService implements IPeopleService {
    @Autowired
    private IPeopleRepository iPeopleRepository;

    @Override
    public int createPeopleId() {
        int count;
        String createId;
        do {
            int[] numbers = new int[5];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int) (Math.random() * 10);
            }
            createId = "";
            for (int number : numbers
            ) {
                createId += Integer.toString(number);
            }
            count = iPeopleRepository.countByPeopleId(Integer.parseInt(createId));
        } while (count != 0);
        return Integer.parseInt(createId);
    }

    @Override
    public boolean updatePeople(People people) {
        try {
            iPeopleRepository.save(people);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deletePeople(People people) {
        try {
            iPeopleRepository.delete(people);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public People findPeopleByPeopleId(int peopleId) throws PersonIdNotExist {
        People people;
        try {
            people = iPeopleRepository.findById(peopleId).orElse(null);
        } catch (Exception e) {
            throw new PersonIdNotExist("Id không tồn tại");
        }
        return people;
    }
}
