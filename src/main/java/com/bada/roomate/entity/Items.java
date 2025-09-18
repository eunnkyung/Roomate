package com.bada.roomate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "itemID")
    private Integer id;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private boolean deleteStatus = false;

    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Likes> LikesList;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Reviews> reviewsList;
}
