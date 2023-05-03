package com.delinkcious.linkservice.domain;

import lombok.*;

import javax.persistence.*;

@Getter @ToString @NoArgsConstructor
@Entity @Table(name = "link")
public class Link extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id", unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column
    private String picture;
    @Builder
    public Link(String url, String title, String description, String picture) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.picture = picture;
    }
    public Link update(String url, String title, String description, String picture) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.picture = picture;

        return this;
    }
}
