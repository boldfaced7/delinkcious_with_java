package com.delinkcious.linkservice.controller;

import com.delinkcious.linkservice.domain.Link;
import com.delinkcious.linkservice.service.LinkService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/links")
public class LinkController {
private final LinkService linkService;
    @GetMapping("/{linkId}")
    public ResponseEntity<Link> getLink(
            @PathVariable("linkId") Long linkId) {
        Link link = linkService.getLink(linkId).orElse(new Link());
        return ResponseEntity.ok(link);
    }
    @PutMapping
    public ResponseEntity<Long> updateLink(@RequestBody Link request) {
        return ResponseEntity.ok(linkService.updateLink(request));
    }
    @PostMapping
    public ResponseEntity<Long> createLink(@RequestBody Link request) {
        return ResponseEntity.ok(linkService.addLink(request));
    }
    @DeleteMapping("/{linkId}")
    public ResponseEntity<String> deleteLink(@PathVariable("linkId") Long linkId) {
        linkService.deleteLink(linkId);
        return ResponseEntity.ok(String.format("link.delete.message %s", linkId));
    }
    @GetMapping
    public ResponseEntity<List<Link>> getLinks(
            @RequestParam("userId") Long userId) {
        List<Link> links = linkService.getUserLinks(userId);
        return ResponseEntity.ok(links);
    }
}
