package com.sparta.daily.controller;

import com.sparta.daily.dto.CommentRequestDto;
import com.sparta.daily.dto.CommentResponseDto;
import com.sparta.daily.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //댓글 등록
    @PostMapping("/comment")
    public CommentResponseDto writeComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.writeComment(requestDto);
    }
    /*
    {
        "dailyId":"1",
        "userId":"1",
        "contents":"댓글내용"
    }

     */

    //댓글 수정
    @PutMapping("/comment/{userid}/{id}/{dailyid}")
    public CommentResponseDto updateComment(@PathVariable ("userid")String userid,
                                            @PathVariable("id") Long id,
                                            @PathVariable("dailyid") Long dailyId,
                                            @RequestBody String contents) {
        return commentService.updateComment(userid,id,dailyId,contents);
    }

    //댓글 삭제
    @DeleteMapping("/comment/{userid}/{id}/{dailyid}")
    public Long deleteComment(@PathVariable("userid") String userid,
                              @PathVariable("id") Long id,
                              @PathVariable("dailyid") Long dailyId){
        return commentService.deleteComment(userid,id,dailyId);
    }


}
