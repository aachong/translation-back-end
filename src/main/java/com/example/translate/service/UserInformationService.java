package com.example.translate.service;

import com.example.translate.entity.UserInformation;
import com.example.translate.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserInformationService {
    @Autowired
    private UserInformationRepository userInformationRepository;
    @Autowired
    private FlowService flowService;

    public Map addUserInformation(UserInformation u){
        List<UserInformation> a = userInformationRepository.findByNameOrPhone(u.getName(), u.getPhone());
        Map result;
        if (a.isEmpty()) result = Map.of("result", userInformationRepository.save(u));
        else result = Map.of("result", "false");
        return result;
    }

    public Map saveUserInformation(UserInformation u){
        Map result = Map.of("result", userInformationRepository.save(u));
        return result;
    }

    public Map signIn(UserInformation userInformation) {
        List<UserInformation> a = userInformationRepository.findByPhoneAndPassword(userInformation.getPhone(), userInformation.getPassword());
        List<UserInformation> b = userInformationRepository.findByNameAndPassword(userInformation.getName(), userInformation.getPassword());
        Map result;
        if (a.isEmpty() && b.isEmpty()) {
            result = Map.of("result", "false");
        } else if (a.isEmpty()) {
            result = Map.of("result", b.get(0));
        } else {
            result = Map.of("result", a.get(0));
        }
        return result;
    }
    public Map money(UserInformation userInformation) {
        UserInformation u = userInformationRepository.findById(userInformation.getId()).get();
        u.setMoney(userInformation.getMoney()+u.getMoney());
        flowService.userMoneyFlow(userInformation);
        Map result = Map.of("result", userInformationRepository.save(u));
        return result;
    }
    public Map get(UserInformation u){
        return Map.of("result",userInformationRepository.findById(u.getId()));
    }

}
