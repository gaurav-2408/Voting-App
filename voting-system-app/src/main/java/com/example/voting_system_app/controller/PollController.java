package com.example.voting_system_app.controller;

import com.example.voting_system_app.entity.Option;
import com.example.voting_system_app.entity.Poll;
import com.example.voting_system_app.entity.PollData;
import com.example.voting_system_app.service.OptionService;
import com.example.voting_system_app.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PollController {

    @Autowired(required = false)
    private PollService pollService;
    @Autowired(required = false)
    private OptionService optionService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("polls", pollService.getAllPolls());
        return "index";
    }

    @GetMapping("/poll/{id}")
    public String viewPoll(@PathVariable int id, Model model){
        model.addAttribute("poll", pollService.getPollById(id));
        return "poll";
    }

    @PostMapping("/poll")
    public String createPoll(@ModelAttribute PollData pollData){
        Poll poll = new Poll();
        poll.setQuestion(pollData.getQuestion());
        List<Option> optionList = new ArrayList<>();
        for(String optionStr : pollData.getOptions()){
            Option option = new Option();
            option.setDesc(optionStr);
            option.setPoll(poll);
            optionList.add(option);
        }
        poll.setOptionList(optionList);
        pollService.createPoll(poll);

        return "redirect:/";
    }

    @PostMapping("/vote")
    public String createVote(int optionId){
        optionService.createVote(optionId);

        return "redirect:/";
    }

    @PostMapping("/poll/{id}/results")
    public String pollResults(@PathVariable int id, Model model){
        model.addAttribute("poll", pollService.getPollById(id));
        return "results";
    }
}
