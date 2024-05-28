package com.sparta.daily;

import com.sparta.daily.dto.CommentRequestDto;
import com.sparta.daily.dto.CommentResponseDto;
import com.sparta.daily.dto.DailyRequestDto;
import com.sparta.daily.entity.Comment;
import com.sparta.daily.repository.CommentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.sparta.daily.entity.Daily;
import com.sparta.daily.repository.DailyRepository;

@SpringBootTest
public class DailyApplicationTests {

    @PersistenceContext
    EntityManager em;

    @Autowired
     DailyRepository dailyRepository;
    @Autowired
    private CommentRepository commentRepository;

//    @Test
//    @Transactional
//    @Rollback(value = false) // 테스트 코드에서 @Transactional 를 사용하면 테스트가 완료된 후 롤백하기 때문에 false 옵션 추가
//    @DisplayName("메모 생성 성공")
//    void test1() {
//        Daily daily = new Daily();
//        daily.setTitle("할일");
//        daily.setContents("내가할일");
//        daily.setWriter("박세미");
//        daily.setPassword("1234");
//
//        em.persist(daily);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
//    }


    @Test
    void test1(){
        DailyRequestDto requestDto = new DailyRequestDto("제목","일정","나여","1");
        Daily daily = new Daily(requestDto);

        Comment comment = new Comment();
        comment.setDailyId(1L);
        comment.setId(1L);
        comment.setUserId("1");
        comment.setContents("와 멋져요");
        daily.addcommentList(comment);

        CommentResponseDto commentRequestDto = new CommentResponseDto(comment);
        commentRepository.save(comment);

        dailyRepository.save(daily);
    }

}
