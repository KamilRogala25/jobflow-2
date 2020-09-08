package com.example.jobflow.data;

import com.example.jobflow.model.Tag;
import com.example.jobflow.model.Website;
import com.example.jobflow.repository.JobDailyOfferRepository;
import com.example.jobflow.repository.TagRepository;
import com.example.jobflow.repository.WebsiteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataCommandLineApp implements CommandLineRunner {

    private TagRepository tagRepository;

    private WebsiteRepository websiteRepository;

    private JobDailyOfferRepository jobDailyOfferRepository;

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
        if (!websiteRepository.findWebPage("pracuj").isPresent()) {
            website = websiteRepository.save(new Website("pracuj", "http://pracuj.pl"));
        }
        String[] tags = {"java","ruby", "project manager" , "hr" ,
                "sprzątaczka", "programista"} ;

        for (String tag: tags){
            if ( !tagRepository.findByName(tag).isPresent()){
                tagRepository.save( new Tag(tag));
            }
        }
    }
}
