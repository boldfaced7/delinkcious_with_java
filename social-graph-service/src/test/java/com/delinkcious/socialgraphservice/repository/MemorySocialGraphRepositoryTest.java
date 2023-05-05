package com.delinkcious.socialgraphservice.repository;

import com.delinkcious.socialgraphservice.domain.Subscription;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class MemorySocialGraphRepositoryTest {
    MemorySocialGraphRepository repository = new MemorySocialGraphRepository();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }
    @Test
    void save() {
        // Given
        Subscription subscription = new Subscription("followee", "follower");

        // When
        repository.save(subscription);

        // Then
        Subscription result = repository.findByFolloweeAndFollower(
                subscription.getFollowee(), subscription.getFollower()).orElse(null);

        assertThat(subscription).isEqualTo(result);
    }

    @Test
    void delete() {
        // Given
        Subscription subscription = new Subscription("followee", "follower");
        repository.save(subscription);

        // When
        repository.delete(subscription);

        // Then
        Subscription result = repository.findByFolloweeAndFollower(
                subscription.getFollowee(), subscription.getFollower()).orElse(null);

        assertThat(result).isEqualTo(null);
    }

    @Test
    void findById() {
        // Given
        Subscription subscription = new Subscription("followee", "follower");
        repository.save(subscription);

        // When
        Subscription result = repository.findById(subscription.getId()).get();

        // Then
        assertThat(subscription).isEqualTo(result);
    }

    @Test
    void findByFollower() {
        // Given
        Subscription subscription = new Subscription("followee", "follower");
        repository.save(subscription);

        // When
        Optional<Subscription> result = repository.findByFollower(subscription.getFollower()).stream().findAny();

        // Then
        assertThat(subscription).isEqualTo(result.get());
    }

    @Test
    void findByFollowee() {
        // Given
        Subscription subscription = new Subscription("followee", "follower");
        repository.save(subscription);

        // When
        Optional<Subscription> result = repository.findByFollowee(subscription.getFollowee()).stream().findAny();

        // Then
        assertThat(subscription).isEqualTo(result.get());

    }

    @Test
    void findByFolloweeAndFollower() {
        // Given
        Subscription subscription = new Subscription("follower", "followee");
        repository.save(subscription);

        // When
        Subscription result = repository.findByFolloweeAndFollower(
                subscription.getFollowee(), subscription.getFollower()).orElse(null);

        // Then
        assertThat(subscription).isEqualTo(result);
    }
}