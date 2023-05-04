package com.delinkcious.linkservice.domain;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @ToString @NoArgsConstructor
@Entity @Table(name = "links")
public class Link extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id", unique = true, nullable = false)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column
    private String picture;
    @Builder
    public Link(Long userId, String url, String title, String description, String picture) {
        this.userId = userId;
        this.url = url;
        this.title = title;
        this.description = description;
        this.picture = picture;
    }
    public Link update(Link link) {
        this.url = link.getUrl();
        this.title = link.getTitle();
        this.description = link.getDescription();
        this.picture = link.getPicture();

        return this;
    }
}
