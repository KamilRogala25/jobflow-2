package com.example.jobflow.api;


import com.example.jobflow.dto.JobDailyOfferDto;
import com.example.jobflow.mapper.JobDailyOfferMapper;
import com.example.jobflow.model.JobDailyOffer;
import com.example.jobflow.repository.JobDailyOfferRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/jobs")
@RestController
public class JobDailyOfferController {


    private JobDailyOfferMapper jobDailyOfferMapper;

    public JobDailyOfferController( JobDailyOfferMapper jobDailyOfferMapper){
        this.jobDailyOfferMapper = jobDailyOfferMapper;
    }

    @GetMapping("")
    public List<JobDailyOfferDto> getList(){
        return jobDailyOfferMapper.convertToListDailyOfferDto();
    }

}
