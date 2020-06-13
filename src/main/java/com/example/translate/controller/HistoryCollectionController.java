package com.example.translate.controller;

import com.example.translate.entity.Collection;
import com.example.translate.entity.History;
import com.example.translate.entity.UserInformation;
import com.example.translate.service.HistoryCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/hc")
public class HistoryCollectionController {
    @Autowired
    private HistoryCollectionService historyCollectionService;

    @PostMapping("/getuser/history")
    public Map getUserHistory(@RequestBody UserInformation u) {

        return historyCollectionService.getUserHistory(u);
    }

    @PostMapping("/getuser/collection")
    public Map getUserCollection(@RequestBody UserInformation u) {

        return historyCollectionService.getUserCollection(u);
    }


    @PostMapping("/add/history")
    public Map addHistory(@RequestBody History h) {
        return historyCollectionService.addHistory(h);
    }

    @PostMapping("/add/collection")
    public Map addCollection(@RequestBody Collection c) {
        return historyCollectionService.addCollection(c);
    }

    @PostMapping("/del/history")
    public Map delHistory(@RequestBody UserInformation h) {
        return historyCollectionService.delHistory(h);
    }

    @PostMapping("/del/collection")
    public Map delCollection(@RequestBody Collection c) {
        return historyCollectionService.delCollection(c);
    }

    @PostMapping("/del/allcollection")
    public Map delCollection(@RequestBody UserInformation c) {
        return historyCollectionService.delAllCollection(c);
    }
}
