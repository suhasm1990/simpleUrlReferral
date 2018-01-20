package com.simpleUrlReferral.simpleUrlReferral.service;

import com.simpleUrlReferral.simpleUrlReferral.domain.Referral;
import com.simpleUrlReferral.simpleUrlReferral.repo.ReferralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferralService {

    private ReferralRepository referralRepository;

    @Autowired
    public ReferralService(ReferralRepository referralRepository){
        this.referralRepository = referralRepository;
    }

    public String createReferral(String domainName){
        Referral referralVal = referralRepository.findBydomainName(domainName);
        if(referralVal == null){
            referralRepository.save(new Referral(domainName, 1));
        }else{
            referralVal.setReferralCount(referralVal.getReferralCount()+1);
            referralRepository.save(referralVal);
        }
        return "saved";
    }

    public List<Referral> getAllDomainList(){
        return referralRepository.findAllByOrderByReferralCountDesc();
    }

}
