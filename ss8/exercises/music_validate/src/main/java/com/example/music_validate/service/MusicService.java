package com.example.music_validate.service;

import com.example.music_validate.model.Music;
import com.example.music_validate.repository.IMusicRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    IMusicRepository iMusicRepository;
    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void add(Music music) {
         iMusicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        iMusicRepository.deleteById(id);
    }
}
