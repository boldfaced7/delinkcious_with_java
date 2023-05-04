package com.delinkcious.linkservice.repository;

import com.delinkcious.linkservice.domain.Link;

import java.util.List;
import java.util.Optional;

public interface LinkRepository {
    public Link save(Link link);
    public void delete(Link link);
    public Optional<Link> findById(Long id);
    public List<Link> findByUserId(Long userId);
}
