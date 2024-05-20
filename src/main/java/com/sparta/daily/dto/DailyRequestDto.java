package com.sparta.daily.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

//@Getter
//public class DailyRequestDto {
//    private String title;       //할일 제목
//    private String contents;    //할일 내용
//    private String writer;      //담당자
//    private String password;    //비밀번호
//}

//  피드백: Java Record type 적용
public record DailyRequestDto(@JsonProperty("title") String title,
                              @JsonProperty("contents") String contents,
                              @JsonProperty("writer") String writer,
                              @JsonProperty("password") String password) { }
