package com.example.music_validate.repository;



import com.example.music_validate.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface IMusicRepository extends JpaRepository<Music,Integer> {

}
