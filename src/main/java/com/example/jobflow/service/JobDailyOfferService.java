package com.example.jobflow.service;

import com.example.jobflow.model.JobDailyOffer;
import com.example.jobflow.model.Tag;
import com.example.jobflow.model.Website;
import com.example.jobflow.repository.JobDailyOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;

@Component
public class JobDailyOfferService {

    @Autowired
    private PracujPlService pracujPlService;

    @Autowired
    private JobDailyOfferRepository jobDailyOfferRepository;

    public void addJobDailyOffer(Tag tag, Website website, String city) {
        try {
            Integer numberOfOffers =
                    pracujPlService.getNumberOfJobs(tag.getName(), city);
            JobDailyOffer jobDailyOffer = JobDailyOffer.builder().
                    city(city).date(LocalDate.now()).number(numberOfOffers).
                    tag(tag).website(website).build();

            jobDailyOfferRepository.save(jobDailyOffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
