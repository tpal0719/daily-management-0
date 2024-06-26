package com.sparta.daily.entity;

import com.sparta.daily.dto.DailyRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "daily") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Daily extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;       //할일 제목
    @Column(name = "contents", nullable = false)
    private String contents;    //할일 내용
    @Column(name = "writer", nullable = false)
    private String writer;      //담당자
    @Column(name = "password", nullable = false)
    private String password;    //비밀번호

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();


    //  피드백: Java Record type 적용
    public Daily(DailyRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.writer = requestDto.getWriter();
        this.password = requestDto.getPassword();
    }


    //  피드백: Java Record type 적용
    public void update(DailyRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.writer = requestDto.getWriter();
        this.password = requestDto.getPassword();
    }

    // 해당 daily에 comment 추가
    public void addcommentList(Comment comment) {
        this.commentList.add(comment);
    }
}
