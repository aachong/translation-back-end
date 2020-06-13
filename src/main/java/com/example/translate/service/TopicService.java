package com.example.translate.service;

import com.example.translate.entity.Content;
import com.example.translate.entity.Topic;
import com.example.translate.entity.UserInformation;
import com.example.translate.repository.ContentRepository;
import com.example.translate.repository.TopicRepository;
import com.example.translate.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private UserInformationRepository userInformationRepository;

    public Map addTopic(Topic t) {
        int id = t.getUserInformation().getId();
        UserInformation u = userInformationRepository.findById(id).get();
        t.setWho(u.getName());
        return Map.of("result", topicRepository.save(t));
    }

    public Map addContent(Content content) {
        int uid = content.getUserInformation().getId();
        UserInformation u = userInformationRepository.findById(uid).get();
        content.setWho(u.getName());
        return Map.of("result",contentRepository.save(content));
    }

    public Map topicList(){
        return Map.of("result",topicRepository.findAll());
    }

    public Map contentList(Topic topic){
        return Map.of("result",contentRepository.findByTopicId(topic.getId()));
    }

    public Map delTopic(Topic topic) {
        List<Content> c = contentRepository.findByTopicId(topic.getId());
        contentRepository.deleteInBatch(c);
        topicRepository.delete(topic);
        return Map.of("result","true");
    }

    public Map delContent(Content content) {
        contentRepository.deleteById(content.getId());
        return Map.of("result","true");
    }
    public Map findTopic(String a){
        a = "%%"+a+"%%";
        return Map.of("result",topicRepository.findByTitle(a));
    }
    public Map findTopicW(String a){
        a = "%%"+a+"%%";
        return Map.of("result",topicRepository.findByWho(a));
    }

    public Map findTopicById(Topic t){
        return Map.of("result",topicRepository.findById(t.getId()));
    }
}
