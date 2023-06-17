package com.john.javaTesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired  
    LetterService letterService;
    @PostMapping("/api/letters")
    public List<LetterGridOutput> letter(@RequestBody LetterSpecification letterSpecification){
        return letterService.create(letterSpecification);
    }
}
