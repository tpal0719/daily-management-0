package com.sparta.daily.controller;

import com.sparta.daily.dto.CommentRequestDto;
import com.sparta.daily.dto.CommentResponseDto;
import com.sparta.daily.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
