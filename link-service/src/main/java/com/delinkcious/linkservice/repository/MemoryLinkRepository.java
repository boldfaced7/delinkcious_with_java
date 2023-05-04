package com.delinkcious.linkservice.repository;

import com.delinkcious.linkservice.domain.Link;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryLinkRepository implements LinkRepository {
    private static Map<Long, Link> store = new HashMap<>();
    private static Long sequence = 0L;
    public void clearStore() {
        store.clear();
    }
    @Override
    public Link save(Link link) {
        link.setId(++sequence);
        store.put(link.getId(), link);
        return link;
    }
    @Override
    public void delete(Link link) {
        store.remove(link.getId());
    }
    @Override
    public Optional<Link> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<Link> findByUserId(Long userId) {
        return store.values().stream()
                .filter(link -> link.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
