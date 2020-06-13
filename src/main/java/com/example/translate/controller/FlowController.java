package com.example.translate.controller;

import com.example.translate.entity.FlowTranslator;
import com.example.translate.entity.FlowUser;
import com.example.translate.entity.Translator;
import com.example.translate.entity.UserInformation;
import com.example.translate.service.FlowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/flow")
public class FlowController {
    @Autowired
    private FlowService flowService;


    @PostMapping("/user")
    public Map getUser(@RequestBody UserInformation f) {
        return flowService.getUser(f);
    }

    @PostMapping("/translator")
    public Map getTranslator(@RequestBody Translator f) {
        return flowService.getTranslator(f);
    }



}
