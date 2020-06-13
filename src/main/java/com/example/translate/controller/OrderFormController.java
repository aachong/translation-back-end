package com.example.translate.controller;

import com.example.translate.entity.OrderForm;
import com.example.translate.entity.Translator;
import com.example.translate.entity.UserInformation;
import com.example.translate.service.OrderFormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderFormController {
    @Autowired
    private OrderFormService orderFormService;
    @PostMapping("/add")
    public Map add(@RequestBody OrderForm o) {
        return orderFormService.addOrderForm(o);
    }
    @PostMapping("/modify")
    public Map modify(@RequestBody OrderForm o) {
        return orderFormService.modifyOrderForm(o);
    }
    @PostMapping("/complete")
    public Map complete(@RequestBody OrderForm o) {
        return orderFormService.compOrderForm(o);
    }
    @PostMapping("/get")
    public Map get(@RequestBody OrderForm o) {
        return orderFormService.getOrderForm(o);
    }

    @PostMapping("/user")
    public Map user(@RequestBody UserInformation o) {
        return orderFormService.getUserOrder(o);
    }

    @PostMapping("/translator")
    public Map translator(@RequestBody Translator o) {
        return orderFormService.getTranslatorOrder(o);
    }


    @PostMapping("/ing")
    public Map getIng() {
        return orderFormService.getIngOrder();
    }

}
