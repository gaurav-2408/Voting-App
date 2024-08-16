package com.example.voting_system_app.repo;

import com.example.voting_system_app.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepo extends JpaRepository<Option,Integer> {
}
