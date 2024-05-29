package com.sparta.daily.service;

import com.sparta.daily.dto.CommentRequestDto;
import com.sparta.daily.dto.CommentResponseDto;
import com.sparta.daily.entity.Comment;
import com.sparta.daily.entity.Daily;
import com.sparta.daily.repository.CommentRepository;
import com.sparta.daily.repository.DailyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    DailyRepository dailyRepository;
    @Autowired
    CommentRepository commentRepository;

    //댓글작성
    public CommentResponseDto writeComment(CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);


        System.out.println("requestDto.getDailyId() = " + requestDto.getDailyId());
        //선택한 일정의 ID를 입력 받지 않은 경우
//@Validation
//        if(requestDto.getDailyId()==null
//        || requestDto.getDailyId().toString().isBlank()
//        || requestDto.getDailyId().toString().isEmpty()){
//            throw new NullPointerException("일정이 선택되지 않았습니다.");
//        }
        // 일정이 DB에 저장되지 않은 경우
        Daily daily = dailyRepository.findDailyById(requestDto.getDailyId()).orElseThrow(

                () -> new NullPointerException("해당하는 일정이 없습니다.")
        );
        //댓글 내용이 비어 있는 경우
//@Validation
//        if (comment.getContents().isBlank()
//                || comment.getContents().isEmpty()) {
//            throw new IllegalArgumentException("댓글 내용이 없습니다.");
//        }

        //save
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        Comment savedComment = commentRepository.save(comment);
        daily.addcommentList(comment);
        dailyRepository.save(daily);


        return commentResponseDto;
    }

    public CommentResponseDto updateComment(String userId,Long id,Long dailyId,String contents) {
        //선택한 일정이나 댓글의 ID를 입력 받지 않은 경우
//@Validation
//        if(dailyId==null || id==null){
//            throw new NullPointerException("일정이나 댓글이 입력되지 않았습니다.");
//        }

        //일정이나 댓글이 DB에 저장되지 않은 경우
        Comment comment = commentRepository.findAllByIdAndDailyId(id,dailyId).orElseThrow(
                ()-> new IllegalArgumentException("해당하는 댓글이 존재하지 않습니다.")
        );

        // 선택한 댓글의 사용자가 현재 사용자와 일치하지 않은 경우
        if (!comment.getUserId().equals(userId)) {
            throw new IllegalArgumentException("잘못된 사용자 입니다.");
        }

        comment.update(contents);
        commentRepository.save(comment);

        return new CommentResponseDto(comment);

    }

    public Long deleteComment(String userid,Long id, Long dailyId) {
        // 선택한 일정이나 댓글의 ID를 입력받지 않은 경우
//@Validation
//        if(dailyId==null || id==null){
//            throw new NullPointerException("일정이나 댓글이 입력되지 않았습니다.");
//        }
        // 일정이나 댓글이 DB에 저장되지 않은 경우
        Comment comment = commentRepository.findAllByIdAndDailyId(id,dailyId).orElseThrow(
                ()-> new NullPointerException("해당하는 댓글이 존재하지 않습니다.")
        );
        // 선택한 댓글의 사용자가 현재 사용자와 일치하지 않은 경우
        if(comment.getUserId().equals(userid)){
            throw new IllegalArgumentException("잘못된 사용자 입니다.");
        }

        Daily daily = dailyRepository.findDailyById(dailyId).orElseThrow(
                ()->new NullPointerException("해당하는 일정이 존재하지 않습니다.")
        );
        daily.getCommentList().remove(comment);
        commentRepository.delete(comment);

        return id;
    }
}
