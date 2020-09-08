package com.example.jobflow.data;

import com.example.jobflow.model.JobDailyOffer;
import com.example.jobflow.model.Tag;
import com.example.jobflow.model.Website;
import com.example.jobflow.repository.JobDailyOfferRepository;
import com.example.jobflow.repository.TagRepository;
import com.example.jobflow.repository.WebsiteRepository;
import com.example.jobflow.service.JobDailyOfferService;
import com.example.jobflow.service.PracujPlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;

@Component
public class DataCommandLineApp implements CommandLineRunner {
    private TagRepository tagRepository;
    private WebsiteRepository websiteRepository;
    private JobDailyOfferRepository jobDailyOfferRepository;
    @Autowired
    private PracujPlService pracujPlService;

    @Autowired
    private JobDailyOfferService jobDailyOfferService;

    public DataCommandLineApp(TagRepository tagRepository,
                              WebsiteRepository websiteRepository,
                              JobDailyOfferRepository jobDailyOfferRepository) {
        this.tagRepository = tagRepository;
        this.websiteRepository = websiteRepository;
        this.jobDailyOfferRepository = jobDailyOfferRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Website website;
        Tag tag;
        if (!websiteRepository.findWebPage("pracuj").isPresent()) {
            website = websiteRepository.save(new Website("pracuj", "http://pracuj.pl"));
        } else {
            website = websiteRepository.findWebPage("pracuj").get();
        }
        String[] tags = {"java", "ruby", "project menager", "hr", "sprzątaczka"
                , "programista"};
        String[] cities = {"warszawa", "kraków", "poznań", "gdańsk", "szczecin", "wrocław"};
        for (String tagName : tags) {
            if (!tagRepository.findByName(tagName).isPresent()) {
                tag = tagRepository.save(new Tag(tagName));
            } else {
                tag = tagRepository.findByName(tagName).get();
            }
            for (String city: cities){
               jobDailyOfferService.addJobDailyOffer(tag,website,city);
            }
//            addJobDailyOffer(tag, website, "warszawa");
        }
    }


}


