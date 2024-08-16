package com.example.voting_system_app.repo;

import com.example.voting_system_app.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepo extends JpaRepository<Vote, Integer> {
}
