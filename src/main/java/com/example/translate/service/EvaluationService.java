package com.example.translate.service;

import com.example.translate.entity.Evaluation;
import com.example.translate.entity.OrderForm;
import com.example.translate.entity.Translator;
import com.example.translate.entity.UserInformation;
import com.example.translate.repository.EvaluationRepository;
import com.example.translate.repository.OrderFormRepository;
import com.example.translate.repository.TranslatorRepository;
import com.example.translate.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private FlowService flowService;
    @Autowired
    private OrderFormRepository orderFormRepository;
    @Autowired
    private TranslatorRepository translatorRepository;
    @Autowired
    private UserInformationRepository userInformationRepository;


    public Map addEvaluation(Evaluation evaluation){
        if(!evaluationRepository.findByOid(evaluation.getOrder().getId()).isEmpty()){
            return Map.of("result","false");
        }
        Evaluation e = evaluationRepository.save(evaluation);
        OrderForm order = orderFormRepository.findById(e.getOrder().getId()).get();
        Translator d = order.getTranslator();

        double rs = d.getRankSatisfaction();
        double rp = d.getRankSpeed();
        int rn = d.getRankPerson();
        rs=(rs*rn+e.getRankSatisfaction())/(rn+1);
        rp=(rp*rn+e.getRankSpeed())/(rn+1);
        rn+=1;
        d.setRankSatisfaction(rs);
        d.setRankSpeed(rp);
        d.setRankPerson(rn);
        translatorRepository.save(d);
        return Map.of("result","true");
    }

    public Map uList(UserInformation u){
//        List<Evaluation> ue = evaluationRepository.findByUid(u.getId());
        return Map.of("result",evaluationRepository.findByUid(u.getId()));
    }

    public Map tList(Translator d){
//        List<Evaluation> e = evaluationRepository.findByTid(d.getId());
        return Map.of("result",evaluationRepository.findByTid(d.getId()));
    }
}
