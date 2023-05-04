package com.delinkcious.linkservice.repository;

import com.delinkcious.linkservice.domain.Link;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class MemoryLinkRepositoryTest {
    MemoryLinkRepository repository = new MemoryLinkRepository();
    @AfterEach
    void afterEach() {
        repository.clearStore();
    }
    @Test
    void save() {
        // Given
        Link link = new Link(1L, "url", "title", "description", "picture");

        // When
        repository.save(link);

        // Then
        Link result = repository.findById(link.getId()).get();
        assertThat(link).isEqualTo(result);
    }

    @Test
    void delete() {
        // Given
        Link link = new Link(1L, "url", "title", "description", "picture");
        repository.save(link);

        // When
        repository.delete(link);

        // Then
        List<Link> result = repository.findByUserId(link.getUserId());
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void findById() {
        // Given
        Link link = new Link(1L, "url", "title", "description", "picture");
        repository.save(link);

        // When
        Link result = repository.findById(link.getId()).get();

        // Then
        assertThat(link).isEqualTo(result);
    }

    @Test
    void findByUserId() {
        // Given
        Link link = new Link(1L, "url", "title", "description", "picture");
        repository.save(link);

        // When
        List<Link> result = repository.findByUserId(link.getUserId());

        // Then
        assertThat(result.size()).isEqualTo(1);
    }
}