package com.example.jobflow.service;

import org.jsoup.Jsoup;

import java.io.IOException;

public class PracujPlService {
    public Integer getNumberOfJobs(String tagName, String city) throws IOException {
        String url = "https://www.pracuj.pl/praca/" + tagName +
                ";kw/" + city + ";wp?rd=30";
        String numberText = Jsoup.connect(url).get()
                .getElementsByClass("results-header__offer-count-text-number").first()
                .text();
        return Integer.parseInt(numberText);
    }

    public static void main(String[] args) {
        
    }
}
