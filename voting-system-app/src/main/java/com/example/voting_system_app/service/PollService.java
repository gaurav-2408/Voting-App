package com.example.voting_system_app.service;

import com.example.voting_system_app.entity.Poll;
import com.example.voting_system_app.repo.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    @Autowired
    private PollRepo pollRepo;

    public List<Poll> getAllPolls(){
        return pollRepo.findAll();
    }

    public Optional<Poll> getPollById(int id){
        return pollRepo.findById(id);
    }

    public void createPoll(Poll poll){
        pollRepo.save(poll);
    }
}
