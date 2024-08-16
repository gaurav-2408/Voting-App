package com.example.voting_system_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int pollId; // This might be redundant if you are associating Votes directly with Polls

    @ManyToOne
    @JoinColumn(name = "option_id") // This is the foreign key column in the Vote table
    private Option optionList; // Change from List<Option> to Option
}
