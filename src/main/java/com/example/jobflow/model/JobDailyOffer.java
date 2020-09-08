package com.example.jobflow.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class JobDailyOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    private LocalDate date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "website_id")
    private Website website;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

}
