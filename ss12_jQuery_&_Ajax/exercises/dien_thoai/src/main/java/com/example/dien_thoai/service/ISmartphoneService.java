package com.example.dien_thoai.service;


import com.example.dien_thoai.model.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Smartphone smartphone);
}
