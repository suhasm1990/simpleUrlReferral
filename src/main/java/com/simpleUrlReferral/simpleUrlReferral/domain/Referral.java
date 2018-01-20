package com.simpleUrlReferral.simpleUrlReferral.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Referral implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 500)
    private String domainName;

    @Column
    private int referralCount;

    public Referral(String domain, int countValue){
        this.domainName = domain;
        this.referralCount = countValue;
    }

    public Referral(){

    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public int getReferralCount() {
        return referralCount;
    }

    public void setReferralCount(int referralCount) {
        this.referralCount = referralCount;
    }
}
