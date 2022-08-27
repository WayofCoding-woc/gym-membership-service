package com.woc.gms.jpa.repo;

import com.woc.gms.cons.SUBSCRIPTION_STATUS;
import com.woc.gms.jpa.entity.PlanSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface PlanSubscriptionRepository extends JpaRepository<PlanSubscription, Integer> {
    List<PlanSubscription> findByStatus(SUBSCRIPTION_STATUS status);

    long countByStatus(SUBSCRIPTION_STATUS status);

    //List<PlanSubscription> findByStatus(SUBSCRIPTION_STATUS status, Pageable pageable);
}
