package com.bada.roomate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "item_like",
        uniqueConstraints = @UniqueConstraint(columnNames = {"item_id", "member_id"}))
@SequenceGenerator(name = "item_like_seq", sequenceName = "ITEM_LIKE_SEQ", allocationSize = 1)
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_like_seq")
    @Column(name = "item_like_id")
    private Integer id;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Items item;


}

