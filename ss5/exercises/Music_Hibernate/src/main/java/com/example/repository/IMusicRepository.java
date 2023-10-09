package com.example.repository;

import com.example.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();
    void add(Music music);
    Music findById(int id);
    void update(Music musicUpdate, int id);
    void delete(int id);
}
