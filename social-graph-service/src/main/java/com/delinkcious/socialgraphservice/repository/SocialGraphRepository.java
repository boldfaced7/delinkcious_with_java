package com.delinkcious.socialgraphservice.repository;

import com.delinkcious.socialgraphservice.domain.Subscription;

import java.util.List;
import java.util.Optional;

public interface SocialGraphRepository {
    Subscription save(Subscription subscription);
    void delete(Subscription subscription);
    Optional<Subscription> findById(Long id);
    List<Subscription> findByFollowee(String followee);
    List<Subscription> findByFollower(String follower);
    Optional<Subscription> findByFolloweeAndFollower(String followee, String follower);

}
