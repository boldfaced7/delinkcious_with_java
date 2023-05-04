package com.delinkcious.linkservice;

import com.delinkcious.linkservice.repository.LinkRepository;
import com.delinkcious.linkservice.service.LinkService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final LinkRepository linkRepository;
    public SpringConfig(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }
    @Bean
    public LinkService linkService() {
        return new LinkService(linkRepository);
    }
}
