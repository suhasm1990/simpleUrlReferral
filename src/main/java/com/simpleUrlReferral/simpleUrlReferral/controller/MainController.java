package com.simpleUrlReferral.simpleUrlReferral.controller;

import com.simpleUrlReferral.simpleUrlReferral.domain.Referral;
import com.simpleUrlReferral.simpleUrlReferral.service.ReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ReferralService referralService;

    @RequestMapping("/domainList")
    public String domainList(Model model){
        List<Referral> referralList = new ArrayList<Referral>();
        referralList = referralService.getAllDomainList();
        model.addAttribute("allDomainList", referralList);
        return "domainList";
    }

    @RequestMapping("/url")
    public String urlReferrral(@RequestParam(value = "domain", required = false) String domain, Model model){
        referralService.createReferral(domain);
        model.addAttribute("message", "Thanks for visiting the site!");
        return "result";
    }
}
