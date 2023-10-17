package com.example.music_validate.service;


import com.example.music_validate.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void add(Music music);
    Music findById(int id);
    void delete(int id);
}
