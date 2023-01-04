package com.mysite.sbb.question;


import lombok.RequiredArgsConstructor;
import org.hibernate.query.sqm.internal.QuerySqmImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

   private final QuestionService questionService;
    @GetMapping("/list")

    public String list(Model model)
    {
     List<Question>  questionList = this.questionService.getList();
        model.addAttribute("questionList",questionList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id)
    {

        Question question = this.questionService.getQuestion(id);   // QuestionController에서 QuestionService의
        model.addAttribute("question",question);        // getQuestion 메서드를 호출하여 Question 객체를 템플릿에 전달할 수 있도록

        return "question_detail";
    }
}
