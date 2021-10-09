package com.example.springboot.Elrandemo.controller;

import com.example.springboot.Elrandemo.domain.CardTemplate;
import com.example.springboot.Elrandemo.domain.GreetingCardRequest;
import com.example.springboot.Elrandemo.service.CardTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/greetingCard")
public class GreetingCardController {

    @Autowired
    CardTemplateService cardTemplateService;

    @GetMapping("/catalog")
    public ResponseEntity<?> getCardTemplates(){
        Map<String, CardTemplate> cardTemplatesMap = cardTemplateService.getCardTemplates();
        return new ResponseEntity<>(cardTemplatesMap.toString(), HttpStatus.OK);
    }

    @PostMapping("/cards")
    public ResponseEntity<?> createGreetingCardByTemplate(@RequestBody GreetingCardRequest greetingCardRequest) throws Exception {
        cardTemplateService.createGreetingCard(greetingCardRequest);
        return new ResponseEntity<>("Greeting card was created successfully", HttpStatus.OK);
    }

    @PutMapping("/cards")
    public ResponseEntity<?> uploadGreetingCardByCardId(@RequestParam("file") MultipartFile file){
        cardTemplateService.uploadGreetingCardByCardId(file);
        return new ResponseEntity<>("File was uploaded successfully", HttpStatus.OK);
    }

}
