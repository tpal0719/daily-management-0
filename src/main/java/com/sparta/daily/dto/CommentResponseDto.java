package com.sparta.daily.dto;

import com.sparta.daily.entity.Comment;
import com.sparta.daily.entity.Daily;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {

    private Long id;
    private Long dailyId;
    private String userId;
    private String contents;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.dailyId = comment.getDailyId();
        this.userId = comment.getUserId();
        this.contents = comment.getContents();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getModifiedAt();
    }
}
