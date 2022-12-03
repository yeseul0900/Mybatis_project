package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class SugController {
    @Autowired
    SugService sugService;
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String suglist(Model model){
        model.addAttribute("list",sugService.getSugList());
        return "board/post";
    }
    @RequestMapping(value = "/add", method= RequestMethod.GET)
    public String addPost(){
        return "board/addform";
    }
    @RequestMapping(value = "/addok", method = RequestMethod.GET)
    public String addPostOK(SuggestionVO vo){
        if(sugService.insertSug(vo) == 0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공");
        return "redirect:post";
    }
    @RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){
        SuggestionVO suggestionVO = sugService.getSug(id);
        model.addAttribute("u",suggestionVO);
        return "board/editform";
    }
    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOK(SuggestionVO vo){
        if(sugService.updateSug(vo) == 0)
            System.out.println("데이터 수정 실패");
        else
            System.out.println("데이터 수정 성공");
        return "redirect:post";
    }
    @RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOK(@PathVariable("id") int id){
        if(sugService.deleteSug(id) == 0)
            System.out.println("데이터 삭제 실패");
        else
            System.out.println("데이터 삭제 성공");
        return "redirect:../post";
    }

}

