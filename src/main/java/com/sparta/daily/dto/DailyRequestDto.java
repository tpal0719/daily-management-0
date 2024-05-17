package com.sparta.daily.dto;

import lombok.Getter;

@Getter
public class DailyRequestDto {
    private String title;       //할일 제목
    private String contents;    //할일 내용
    private String writer;      //담당자
    private String password;    //비밀번호
}
