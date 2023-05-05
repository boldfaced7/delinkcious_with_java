package com.delinkcious.socialgraphservice.domain;
import lombok.*;

import javax.persistence.*;

@Getter @Setter @ToString @NoArgsConstructor
@Entity @Table(name = "subscriptions")
public class Subscription extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String followee;
    @Column(nullable = false)
    private String follower;

    @Builder
    public Subscription(String followee, String follower) {
        this.followee = followee;
        this.follower = follower;
    }
    public Subscription update(Subscription subscription) {
        this.followee = subscription.getFollowee();
        this.follower = subscription.getFollower();
        return this;
    }
}
