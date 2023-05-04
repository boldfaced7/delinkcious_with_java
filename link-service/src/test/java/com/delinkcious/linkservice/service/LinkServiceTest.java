package com.delinkcious.linkservice.service;

import com.delinkcious.linkservice.domain.Link;
import com.delinkcious.linkservice.repository.LinkRepository;
import com.delinkcious.linkservice.repository.MemoryLinkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class LinkServiceTest {
    LinkService linkService;
    LinkRepository linkRepository;
    @BeforeEach
    public void beforeEach() {
        linkRepository = new MemoryLinkRepository();
        linkService = new LinkService(linkRepository);
    }

    @Test
    void updateLink() {
        // Given
        Link link = new Link(1L, "url", "title", "description", "picture");
        linkService.addLink(link);

        // When
        linkService.deleteLink(link.getId());

        // Then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> linkService.updateLink(link));
        assertThat(e.getMessage()).isEqualTo("해당 링크는 존재하지 않습니다.");
    }

    @Test
    void deleteLink() {
        // Given
        Link link = new Link(1L, "url", "title", "description", "picture");
        linkService.addLink(link);

        // When
        linkService.deleteLink(link.getId());

        // Then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> linkService.deleteLink(link.getId()));
        assertThat(e.getMessage()).isEqualTo("해당 링크는 존재하지 않습니다.");
    }
}