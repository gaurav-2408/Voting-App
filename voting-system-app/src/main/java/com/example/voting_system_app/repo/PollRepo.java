package com.example.voting_system_app.repo;

import com.example.voting_system_app.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepo extends JpaRepository<Poll, Integer> {
}
