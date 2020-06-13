package com.example.translate.controller;

import com.example.translate.entity.Content;
import com.example.translate.entity.Topic;
import com.example.translate.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @PostMapping("/add")
    public Map addTopic(@RequestBody Topic t) {
        return topicService.addTopic(t);
    }

    @PostMapping("/del")
    public Map delTopic(@RequestBody Topic t) {
        return topicService.delTopic(t);
    }

    @RequestMapping("/all")
    public Map topicList() {
        return topicService.topicList();
    }

    @PostMapping("/addcontent")
    public Map addContent(@RequestBody Content c) {
        return topicService.addContent(c);
    }

    @PostMapping("/delcontent")
    public Map delContent(@RequestBody Content c) {
        return topicService.delContent(c);
    }

    @PostMapping("/allcontent")
    public Map contentList(@RequestBody Topic t) {
        return topicService.contentList(t);
    }

    @PostMapping("/id")
    public Map findById(@RequestBody Topic t){
        return topicService.findTopicById(t);
    }

    @GetMapping("/findw/{a}")
    public Map findTopicW(@PathVariable String a) {
        return topicService.findTopicW(a);
    }

    @GetMapping("/find/{a}")
    public Map findTopic(@PathVariable String a) {
        return topicService.findTopic(a);
    }
}
