package com.example.music_validate.model;

import javax.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String musicName;
    private String singer;
    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private MusicType musicType;
    private String file;

    public Music() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public MusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }
}
