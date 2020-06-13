package com.example.translate.service;

import com.example.translate.entity.Collection;
import com.example.translate.entity.History;
import com.example.translate.entity.UserInformation;
import com.example.translate.repository.CollectionRepository;
import com.example.translate.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HistoryCollectionService {
    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    public Map getUserHistory(UserInformation u){
        return Map.of("result",historyRepository.findByUserId(u.getId()));
    }
    public Map getUserCollection(UserInformation u){
        return Map.of("result",collectionRepository.findByUserId(u.getId()));
    }



    public Map addHistory(History h){
        return Map.of("result",historyRepository.save(h));
    }
    public Map addCollection(Collection c){
        return Map.of("result",collectionRepository.save(c));
    }

    public Map delHistory(UserInformation u){
        List<History> h = historyRepository.findByUserId(u.getId());
        historyRepository.deleteInBatch(h);
        return Map.of("result","true");
    }

    public Map delCollection(Collection c){
        collectionRepository.deleteById(c.getId());
        return Map.of("result","true");
    }

    public Map delAllCollection(UserInformation u){
        List<Collection> h = collectionRepository.findByUserId(u.getId());
        collectionRepository.deleteInBatch(h);
        return Map.of("result","true");
    }
}
