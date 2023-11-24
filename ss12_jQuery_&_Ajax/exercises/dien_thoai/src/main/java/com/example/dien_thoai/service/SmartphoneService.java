package com.example.dien_thoai.service;


import com.example.dien_thoai.model.Smartphone;
import com.example.dien_thoai.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return iSmartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return iSmartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return iSmartphoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Smartphone smartphone) {
        iSmartphoneRepository.delete(smartphone);
    }
}
