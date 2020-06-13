package com.example.translate.controller;

import com.example.translate.entity.Translator;
import com.example.translate.entity.UserInformation;
import com.example.translate.service.TranslatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/translator")
public class TranslatorController {
    @Autowired
    private TranslatorService translatorService;

    @PostMapping("/add")
    public Map add(@RequestBody Translator t) {
        return translatorService.addTranslator(t);
    }

    @PostMapping("/save")
    public Map save(@RequestBody Translator u) {
        return translatorService.saveTranslator(u);
    }

    @PostMapping("/in")
    public Map signIn(@RequestBody Translator u) {
        return translatorService.signIn(u);
    }

    @PostMapping("/money")
    public Map money(@RequestBody Translator u) {
        return translatorService.money(u);
    }

    @PostMapping("/get")
    public Map get(@RequestBody Translator u) {
        return translatorService.get(u);
    }

}
