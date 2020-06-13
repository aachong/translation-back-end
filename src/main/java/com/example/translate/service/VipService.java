package com.example.translate.service;

import com.example.translate.entity.UserInformation;
import com.example.translate.entity.Vip;
import com.example.translate.repository.VipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class VipService {
    @Autowired
    private VipRepository vipRepository;
    @Autowired
    private FlowService flowService;

    public Map addVip(Vip v){
        Vip vv = vipRepository.save(v);
        flowService.vipFlow(v);
        return Map.of("result",vv);
    }
    public Map getUVip(UserInformation u){
        return Map.of("result",vipRepository.findByUserID(u.getId()));
    }
    public Map isVip(UserInformation u){
        List<Vip> v = vipRepository.findByUserId(u.getId());
        String result;
        if(v.isEmpty())return Map.of("result","false");
        else{
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//设置日期格式
            LocalDateTime ldt = LocalDateTime.now();
            if(ldt.isBefore(v.get(0).getEndTime())){
                return Map.of("result",v);
            }else{
                v.get(0).setStatus(0);
                vipRepository.save(v.get(0));
                return Map.of("result","false");
            }

        }
    }
}
