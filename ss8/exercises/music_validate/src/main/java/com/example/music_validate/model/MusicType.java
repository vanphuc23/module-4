package com.example.music_validate.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class MusicType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "musicType",cascade = CascadeType.ALL)
    private List<Music> music;

    public MusicType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
