package com.example.translate.service;

import com.example.translate.entity.*;
import com.example.translate.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class FlowService {
    @Autowired
    private FlowTranslatorRepository flowTranslatorRepository;
    @Autowired
    private FlowUserRepository flowUserRepository;
    @Autowired
    private OrderFormRepository orderFormRepository;
    @Autowired
    private UserInformationRepository userInformationRepository;
    @Autowired
    private TranslatorRepository translatorRepository;

    public Map addFlow(OrderForm o){
        o = orderFormRepository.findById(o.getId()).get();
        FlowUser f = new FlowUser();
        f.setOrderForm(o);
        f.setTransaction(-o.getCost());
        f.setTranslator(o.getTranslator().getName());
        f.setUserInformation(o.getUserInformation());
        flowUserRepository.save(f);
        UserInformation u = userInformationRepository.findById(o.getUserInformation().getId()).get();
        u.setMoney(u.getMoney()-o.getCost());
        userInformationRepository.save(u);

        FlowTranslator t = new FlowTranslator();
        t.setOrderForm(o);
        t.setTransaction(o.getCost());
        t.setTranslator(o.getTranslator());
        t.setUser(o.getUserInformation().getName());
        flowTranslatorRepository.save(t);
        Translator tr = translatorRepository.findById(o.getTranslator().getId()).get();
        tr.setMoney(tr.getMoney()+o.getCost());
        translatorRepository.save(tr);
        return Map.of("result","true");
    }
    public Map vipFlow(Vip v){
        FlowUser f = new FlowUser();
        f.setTranslator("会员开通");
        f.setTransaction(-v.getCost());
        f.setUserInformation(v.getUserInformation());
        flowUserRepository.save(f);
        UserInformation u = userInformationRepository.findById(v.getUserInformation().getId()).get();
        u.setMoney(u.getMoney()-v.getCost());
        userInformationRepository.save(u);
        return Map.of("result","true");
    }

    public Map userMoneyFlow(UserInformation u){
        FlowUser f = new FlowUser();
        f.setTranslator("充值");
        f.setTransaction(u.getMoney());
        f.setUserInformation(u);
        flowUserRepository.save(f);
        return Map.of("result","true");
    }
    public Map translatorMoneyFlow(Translator u){
        FlowTranslator f = new FlowTranslator();
        f.setUser("提现");
        f.setTransaction(-u.getMoney());
        f.setTranslator(u);
        flowTranslatorRepository.save(f);
        return Map.of("result","true");
    }
    public Map getUser(UserInformation u){
        return Map.of("result",flowUserRepository.findByUserId(u.getId()));
    }
    public Map getTranslator(Translator u){
        return Map.of("result",flowTranslatorRepository.findByTranslatorId(u.getId()));
    }

    public Map addTranslator(FlowTranslator f){
        return Map.of("result",0);
    }
}
