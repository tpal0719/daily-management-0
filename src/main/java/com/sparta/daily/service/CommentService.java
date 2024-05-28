package com.sparta.daily.service;

import com.sparta.daily.dto.CommentRequestDto;
import com.sparta.daily.dto.CommentResponseDto;
import com.sparta.daily.entity.Comment;
import com.sparta.daily.entity.Daily;
import com.sparta.daily.repository.CommentRepository;
import com.sparta.daily.repository.DailyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    DailyRepository dailyRepository;
    @Autowired
    CommentRepository commentRepository;

    //댓글작성
    public CommentResponseDto writeComment(CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);

        //선택한 일정의 ID를 입력 받지 않은 경우
        if(requestDto.getDailyId().describeConstable().isEmpty()){

            throw new IllegalArgumentException("일정이 선택되지 않았습니다.");
        }
        // 일정이 DB에 저장되지 않은 경우
        Daily daily = dailyRepository.findDailyById(requestDto.getDailyId()).orElseThrow(

                () -> new NullPointerException("해당하는 일정이 없습니다.")
        );
        //댓글 내용이 비어 있는 경우
        if (comment.getContents().isBlank()
                || comment.getContents().isEmpty()) {
            throw new IllegalArgumentException("댓글 내용이 없습니다.");
        }

        //save
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        Comment savedComment = commentRepository.save(comment);
        daily.addcommentList(comment);
        dailyRepository.save(daily);


        return commentResponseDto;
    }
}
