package com.sparta.daily.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.daily.entity.Daily;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class DailyRequestDto {
    @NotBlank
    private String title;       //할일 제목
    @NotBlank
    private String contents;    //할일 내용
    @NotBlank
    private String writer;      //담당자
    @NotBlank
    private String password;    //비밀번호
}

//  피드백: Java Record type 적용
//public record DailyRequestDto(@JsonProperty("title") String title,
//                              @JsonProperty("contents") String contents,
//                              @JsonProperty("writer") String writer,
//                              @JsonProperty("password") String password) { }

