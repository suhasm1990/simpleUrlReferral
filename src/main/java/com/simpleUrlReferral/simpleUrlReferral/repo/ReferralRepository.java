package com.simpleUrlReferral.simpleUrlReferral.repo;

import com.simpleUrlReferral.simpleUrlReferral.domain.Referral;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReferralRepository extends CrudRepository<Referral, Integer> {
    Referral findBydomainName(String domainName);

    List<Referral> findAllByOrderByReferralCountDesc();

}
