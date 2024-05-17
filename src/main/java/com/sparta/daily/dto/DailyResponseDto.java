package com.sparta.daily.dto;

import com.sparta.daily.entity.Daily;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DailyResponseDto {
    private Long id;
    private String title;       //할일 제목
    private String contents;    //할일 내용
    private String writer;
//    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;//비밀번호

    public DailyResponseDto(Daily daily) {
        this.id = daily.getId();
        this.title = daily.getTitle();
        this.contents = daily.getContents();
        this.writer = daily.getWriter();
//        this.password = daily.getPassword();
        this.createdAt = daily.getCreatedAt();
        this.modifiedAt = daily.getModifiedAt();
    }
}
