package com.example.music_validate.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class MusicDto implements Validator {
    private Integer id;
    @NotBlank(message = "Không được để trống")
    private String musicName;
    @NotBlank(message = "Không được để trống")
    private String singer;
    @NotBlank(message = "Không được để trống")
    private String musicType;
    private String file;

    public MusicDto() {
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

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto)target;
        if(musicDto.getMusicName().length()>=800) {
            errors.rejectValue("musicName",null,"Không vượt quá 800 ký tự");
        } else if(!musicDto.getMusicName().matches("^[a-zA-Z0-9\\s\\u00C0-\\u1EF9]*$")) {
            errors.rejectValue("musicName",null,"Không chứa các kí tự đặc biệt như @ ; , . = - + , ….");
        }
        if(musicDto.getSinger().length()>=300) {
            errors.rejectValue("singer",null,"Không vượt quá 300 ký tự");
        } else if(!musicDto.getSinger().matches("^[a-zA-Z0-9\\s\\u00C0-\\u1EF9]*$")) {
            errors.rejectValue("singer",null,"Không chứa các kí tự đặc biệt như @ ; , . = - + , ….");
        }
        if(musicDto.getMusicType().length()>=1000) {
            errors.rejectValue("musicType",null,"Không vượt quá 1000 ký tự");
        } else if(!musicDto.getMusicType().matches("^[a-zA-Z0-9\\s\\u00C0-\\u1EF9,]*$")) {
            errors.rejectValue("musicType",null,"Ngoại trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được phép");
        }
    }
}
