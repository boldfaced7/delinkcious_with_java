package com.delinkcious.linkservice.service;

import com.delinkcious.linkservice.domain.Link;
import com.delinkcious.linkservice.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository linkRepository;
    public List<Link> getUserLinks(Long userId) {
        return linkRepository.findByUserId(userId);
    }
    public Optional<Link> getLink(Long id) {
        return linkRepository.findById(id);
    }
    public Long addLink(Link link) {
        return linkRepository.save(link).getId();
    }
    @Transactional
    public Long updateLink(Link newLink) {
        Link targetLink = validateExistingLink(newLink.getId());
        return targetLink.update(newLink).getId();
    }
    public void deleteLink(Long id) {
        Link link = validateExistingLink(id);
        linkRepository.delete(link);
    }
    private Link validateExistingLink(Long id) {
        return linkRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 링크는 존재하지 않습니다."));
    }
}