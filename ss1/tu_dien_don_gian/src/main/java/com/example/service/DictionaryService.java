package com.example.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService{

    @Override
    public Map<String, String> search() {
        Map<String, String> map = new HashMap<>();
        map.put("hello","xin chào");
        map.put("name","tên");
        return map;
    }
}
