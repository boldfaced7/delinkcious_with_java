package com.delinkcious.socialgraphservice.repository;

import com.delinkcious.socialgraphservice.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaSocialGraphRepository extends JpaRepository<Subscription, Long>, SocialGraphRepository {
    List<Subscription> findByFollowee(String followee);
    List<Subscription> findByFollower(String follower);
    Optional<Subscription> findByFolloweeAndFollower(String followee, String follower);
}
