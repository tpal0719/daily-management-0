package com.sparta.daily.dto;

import lombok.Getter;

@Getter
public class  CommentRequestDto {
    private Long dailyId;
    private Long userId;
    private String contents;
}
