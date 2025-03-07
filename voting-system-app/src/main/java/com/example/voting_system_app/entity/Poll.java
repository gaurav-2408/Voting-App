package com.example.voting_system_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    @OneToMany(mappedBy = "poll",cascade = CascadeType.ALL)                                        //because one poll have many qustions
    private List<Option>optionList = new ArrayList<>();
}
