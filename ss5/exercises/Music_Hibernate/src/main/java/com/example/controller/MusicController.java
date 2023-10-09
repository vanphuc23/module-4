package com.example.controller;

import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("music", new Music());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        iMusicService.add(music);
        redirectAttributes.addFlashAttribute("mess","ADD SUCCESS");
        return "redirect:/music";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        Music music = iMusicService.findById(id);
        model.addAttribute("musicFind",music);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        iMusicService.update(music, music.getId());
        redirectAttributes.addFlashAttribute("mess","UPDATE SUCCESS");
        return "redirect:/music";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iMusicService.delete(id);
        redirectAttributes.addFlashAttribute("mess","DELETE SUCCESS");
        return "redirect:/music";
    }
}
