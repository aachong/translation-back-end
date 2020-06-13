package com.example.translate.controller;

import com.example.translate.entity.UserInformation;
import com.example.translate.service.UserInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserInformationController {
    @Autowired
    private UserInformationService userInformationService;

    @PostMapping("/add")
    public Map add(@RequestBody UserInformation u) {
        return userInformationService.addUserInformation(u);
    }

    @PostMapping("/save")
    public Map save(@RequestBody UserInformation u) {
        return userInformationService.saveUserInformation(u);
    }
    @PostMapping("/in")
    public Map signIn(@RequestBody UserInformation u) {
        return userInformationService.signIn(u);
    }

    @PostMapping("/money")
    public Map money(@RequestBody UserInformation u) {
        return userInformationService.money(u);
    }

    @PostMapping("/get")
    public Map get(@RequestBody UserInformation u) {
        return userInformationService.get(u);
    }

}
