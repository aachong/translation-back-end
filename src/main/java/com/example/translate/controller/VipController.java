package com.example.translate.controller;

import com.example.translate.entity.UserInformation;
import com.example.translate.entity.Vip;
import com.example.translate.service.VipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/vip")
public class VipController {
    @Autowired
    private VipService vipService;

    @PostMapping("/add")
    public Map add(@RequestBody Vip v) {
        return vipService.addVip(v);
    }

    @PostMapping("/is")
    public Map isVip(@RequestBody UserInformation v) {
        return vipService.isVip(v);
    }

    @PostMapping("/get")
    public Map getUVip(@RequestBody UserInformation v) {
        return vipService.getUVip(v);
    }

}
