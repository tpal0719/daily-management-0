package com.sparta.daily.controller;

import com.sparta.daily.dto.LoginRequestDto;
import com.sparta.daily.dto.SignupRequestDto;
import com.sparta.daily.service.UserService;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/user/signup")
    public String signup(@Valid SignupRequestDto requestDto, BindingResult bindingResult) {
        // Validation 예외처리
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors.size() > 0) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            return "가입하지 못했습니다.";
        }

        userService.signup(requestDto);

        return "가입완료";
    }


//    @PostMapping("/user/login")
//    public void login(@RequestBody LoginRequestDto requestDto, HttpServletResponse res) throws IOException {
//
//    }
}
