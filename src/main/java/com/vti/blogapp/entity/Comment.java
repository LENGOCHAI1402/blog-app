package com.vti.blogapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 75, nullable = false)
    private String email;

    @Column(name = "body", length = 100, nullable = false)
    private String body;

    @Column(name = "create_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

    @Column(name = "updateAt", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;
}
