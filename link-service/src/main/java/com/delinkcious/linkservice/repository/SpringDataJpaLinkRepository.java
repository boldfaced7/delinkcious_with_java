package com.delinkcious.linkservice.repository;

import com.delinkcious.linkservice.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaLinkRepository extends JpaRepository<Link, Long>, LinkRepository {
    public List<Link> findByUserId(Long userId);
}
