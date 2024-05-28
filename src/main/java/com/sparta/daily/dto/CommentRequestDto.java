package com.sparta.daily.dto;

import lombok.Getter;

@Getter
public class  CommentRequestDto {
    private Long dailyId;
    private String userId;
    private String contents;
}
