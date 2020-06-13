package com.example.translate.controller;

import com.example.translate.entity.Evaluation;
import com.example.translate.entity.Translator;
import com.example.translate.entity.UserInformation;
import com.example.translate.service.EvaluationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/add")
    public Map add(@RequestBody Evaluation e) {
        return evaluationService.addEvaluation(e);
    }

    @PostMapping("/ulist")
    public Map uList(@RequestBody UserInformation u) {
        return evaluationService.uList(u);
    }

    //    返回某个订单司机的信息
    @PostMapping("/tlist")
    public Map tList(@RequestBody Translator u) {
        return evaluationService.tList(u);
    }


}
