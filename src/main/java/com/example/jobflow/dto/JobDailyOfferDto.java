package com.example.jobflow.dto;


// DTO = data transfer object
// klasa która jest odpowiedzialna za zwracanie json
// pokazuje jak to ma wyglądać

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDailyOfferDto {

    private String tagName;

    private String city;

    private Integer quantity;

    public JobDailyOfferDto(String tagName, String city, Integer quantity) {
        this.tagName = tagName;
        this.city = city;
        this.quantity = quantity;
    }
}
