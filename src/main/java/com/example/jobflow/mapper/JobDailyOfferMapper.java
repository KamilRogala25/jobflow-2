package com.example.jobflow.mapper;

import com.example.jobflow.dto.JobDailyOfferDto;
import com.example.jobflow.repository.JobDailyOfferRepository;
import com.google.common.collect.FluentIterable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobDailyOfferMapper {

    private JobDailyOfferRepository jobDailyOfferRepository;

    public JobDailyOfferMapper(JobDailyOfferRepository jobDailyOfferRepository) {
        this.jobDailyOfferRepository = jobDailyOfferRepository;
    }

    public List<JobDailyOfferDto> convertToListDailyOfferDto() {
        return FluentIterable.from(jobDailyOfferRepository.findAll()).toList()
                .stream().map(jobDailyOffer -> new
                        JobDailyOfferDto(jobDailyOffer.getTag().getName()
                        , jobDailyOffer.getCity(), jobDailyOffer.getNumber()))
                .collect(Collectors.toList());
    }

}
