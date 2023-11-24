package com.example.thi.controller;

import com.example.thi.dto.QuestionContentDto;
import com.example.thi.model.QuestionContent;
import com.example.thi.model.QuestionType;
import com.example.thi.service.IQuestionService;
import com.example.thi.service.IQuestionTypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private IQuestionService iQuestionService;
    @Autowired
    private IQuestionTypeService iQuestionTypeService;

    @GetMapping("")
    public String showQuestion(Model model, @PageableDefault(page = 0,size = 1) Pageable pageable){
        Page<QuestionContent> questionContents = iQuestionService.findAll(pageable);
        model.addAttribute("questionContents", questionContents);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateQuestion(Model model) {
        model.addAttribute("questionContentDto", new QuestionContentDto());
        model.addAttribute("questionType", iQuestionTypeService.listQuestionType());
        return "create";
    }

    @PostMapping("/create")
    public String createQuestion(@Valid @ModelAttribute QuestionContentDto questionContentDto,
                                 BindingResult bindingResult, Model model,
                                 RedirectAttributes redirectAttributes) {
        new QuestionContentDto().validate(questionContentDto,bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("questionContentDto",questionContentDto);
            model.addAttribute("questionType", iQuestionTypeService.listQuestionType());
            return "create";
        }
        QuestionContent questionContent = new QuestionContent();
        BeanUtils.copyProperties(questionContentDto,questionContent);
        questionContent.setDateCreate(LocalDate.now());
        questionContent.setStatus(0);
        iQuestionService.save(questionContent);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/questions";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long id,RedirectAttributes redirectAttributes) {
        QuestionContent questionContent= iQuestionService.findById(id);
        iQuestionService.delete(questionContent);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/questions";
    }
    @GetMapping("{id}")
    public String search(@PathVariable Long id,Model model) {
        QuestionContent questionContent = iQuestionService.findById(id);
        model.addAttribute("question",questionContent);
        return "list";
    }
}
