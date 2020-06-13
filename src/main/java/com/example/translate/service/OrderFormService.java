package com.example.translate.service;

import com.example.translate.entity.OrderForm;
import com.example.translate.entity.Translator;
import com.example.translate.entity.UserInformation;
import com.example.translate.repository.OrderFormRepository;
import com.example.translate.repository.UserInformationRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderFormService {
    @Autowired
    private OrderFormRepository orderFormRepository;
    @Autowired
    private FlowService flowService;
    @Autowired
    private UserInformationRepository userInformationRepository;

    public Map addOrderForm(OrderForm o){
        o.setStatus(0);
        UserInformation u = userInformationRepository.findById(o.getUserInformation().getId()).get();
        u.setNumberOrder(u.getNumberOrder()+1);
        userInformationRepository.save(u);
        return Map.of("result",orderFormRepository.save(o));
    }

    public Map modifyOrderForm(OrderForm o){
        OrderForm f = orderFormRepository.findById(o.getId()).get();
        f.setTranslator(o.getTranslator());
        System.out.println(f.getTranslator().getId());
        return Map.of("result",orderFormRepository.save(f));
    }

    public Map compOrderForm(OrderForm o){
        OrderForm f = orderFormRepository.findById(o.getId()).get();
        f.setTranslation(o.getTranslation());
        f.setStatus(1);
        orderFormRepository.save(f);
        flowService.addFlow(f);

        return Map.of("result","true");
    }

    public Map getOrderForm(OrderForm o){
        OrderForm or = orderFormRepository.findById(o.getId()).get();
        if(or.getTranslator()!=null)
            or.getTranslator().getName();

        return Map.of("result",or);
    }
    public Map getIngOrder(){
        List<OrderForm> l = orderFormRepository.findByStatus();
        for(int i=0;i<l.size();i++){
            if(l.get(i).getTranslator()!=null){
                l.remove(i--);
            }
        }
        return Map.of("result",l);
    }
    public Map getUserOrder(UserInformation u){
        return Map.of("result",orderFormRepository.findByUserId(u.getId()));
    }

    public Map getTranslatorOrder(Translator u){
        return Map.of("result",orderFormRepository.findByTranslatorId(u.getId()));
    }
}
