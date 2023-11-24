package com.example.music_validate.controller;


import com.example.music_validate.dto.MusicDto;
import com.example.music_validate.model.Music;
import com.example.music_validate.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    IMusicService iMusicService;

    @GetMapping("")
    public String showListMusic(Model model) {
        List<Music> list = iMusicService.findAll();
        model.addAttribute("music", list);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("musicDto", musicDto);
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.add(music);
        redirectAttributes.addFlashAttribute("mess", "ADD SUCCESS");
        return "redirect:/music";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        Music music = iMusicService.findById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicDto", musicDto);
        return "update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("musicDto", musicDto);
            return "update";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.add(music);
        redirectAttributes.addFlashAttribute("mess", "UPDATE SUCCESS");
        return "redirect:/music";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iMusicService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "DELETE SUCCESS");
        return "redirect:/music";
    }
}
