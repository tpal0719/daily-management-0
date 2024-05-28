package com.sparta.daily.entity;

import com.sparta.daily.dto.CommentRequestDto;
import com.sparta.daily.dto.DailyRequestDto;
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
    Long dailyId;

    @Column(name = "userid", nullable = false)
    Long userId;

    @Column(name = "contents", nullable = true)
    String contents;


    public Comment(CommentRequestDto requestDto) {
        this.dailyId = requestDto.getDailyId();
        this.userId = requestDto.getUserId();
        this.contents = requestDto.getContents();
    }

}
