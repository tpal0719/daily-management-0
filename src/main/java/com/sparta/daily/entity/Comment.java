package com.sparta.daily.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dailyid", nullable = false)
    String dailyId;

    @Column(name = "userid", nullable = false)
    String userId;

    @Column(name = "contents", nullable = false)
    String contents;


}
