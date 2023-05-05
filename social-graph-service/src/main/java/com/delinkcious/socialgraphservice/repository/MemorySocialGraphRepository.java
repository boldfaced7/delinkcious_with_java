package com.delinkcious.socialgraphservice.repository;

import com.delinkcious.socialgraphservice.domain.Subscription;

import java.util.*;
import java.util.stream.Collectors;

public class MemorySocialGraphRepository implements SocialGraphRepository {
    private static Map<Long, Subscription> store = new HashMap<>();
    private static Long sequence = 0L;

    public void clearStore() {
        store.clear();
    }

    @Override
    public Subscription save(Subscription subscription) {
        subscription.setId(++sequence);
        store.put(subscription.getId(), subscription);

        return subscription;
    }

    @Override
    public void delete(Subscription subscription) {
        store.remove(subscription.getId());
    }

    @Override
    public Optional<Subscription> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Subscription> findByFollowee(String followee) {
        return store.values().stream()
                .filter(subscription -> subscription.getFollowee().equals(followee))
                .collect(Collectors.toList());
    }

    @Override
    public List<Subscription> findByFollower(String follower) {
        return store.values().stream()
                .filter(subscription -> subscription.getFollower().equals(follower))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Subscription> findByFolloweeAndFollower(String followee, String follower) {
        return store.values().stream()
                .filter(subscription -> subscription.getFollowee().equals(followee))
                .filter(subscription -> subscription.getFollower().equals(follower))
                .findAny();
    }
}
