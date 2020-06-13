package com.example.translate.service;

import com.example.translate.entity.Translator;
import com.example.translate.entity.UserInformation;
import com.example.translate.repository.TranslatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TranslatorService {
    @Autowired
    private TranslatorRepository translatorRepository;
    @Autowired
    private FlowService flowService;

    public Map addTranslator(Translator u){
        List<Translator> a = translatorRepository.findByNameOrPhone(u.getName(), u.getPhone());
        Map result;
        if (a.isEmpty()) result = Map.of("result", translatorRepository.save(u));
        else result = Map.of("result", "false");
        return result;
    }

    public Map saveTranslator(Translator u){
        Map result = Map.of("result", translatorRepository.save(u));
        return result;
    }

    public Map signIn(Translator userInformation) {
        List<Translator> a = translatorRepository.findByPhoneAndPassword(userInformation.getPhone(), userInformation.getPassword());
        List<Translator> b = translatorRepository.findByNameAndPassword(userInformation.getName(), userInformation.getPassword());
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

    public Map money(Translator translator) {
        Translator t = translatorRepository.findById(translator.getId()).get();
        t.setMoney(t.getMoney()-translator.getMoney());
        flowService.translatorMoneyFlow(translator);
        Map result = Map.of("result", translatorRepository.save(t));
        return result;
    }
    public Map get(Translator u){
        return Map.of("result",translatorRepository.findById(u.getId()));
    }

}
