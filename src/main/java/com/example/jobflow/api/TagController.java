package com.example.jobflow.api;


import com.example.jobflow.model.Tag;
import com.example.jobflow.repository.TagRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/tags")
@RestController
public class TagController {

    public TagRepository tagRepository;

    public TagController(TagRepository tagRepository){
        this.tagRepository=tagRepository;
    }

    @GetMapping("")
    public Iterable<Tag> getList(){
        return tagRepository.findAll();
    }
}
