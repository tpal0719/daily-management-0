package com.sparta.daily.controller;

import com.sparta.daily.dto.DailyRequestDto;
import com.sparta.daily.dto.DailyResponseDto;
import com.sparta.daily.service.DailyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DailyController {
    private final DailyService dailyService;

    public DailyController(DailyService dailyService) {
        this.dailyService = dailyService;
    }

    @PostMapping("/dailys")
    public DailyResponseDto writeDaily(@RequestBody DailyRequestDto requestDto) {
        return dailyService.writeDaily(requestDto);
    }

    @GetMapping("/dailys")
    public List<DailyResponseDto> getAllDailys() {
        return dailyService.getAllDailys();
    }

    @GetMapping("/dailys/{id}")
    public DailyResponseDto getDailyById(@PathVariable("id") Long id) {
        return dailyService.getDailyById(id);
    }

    @PutMapping("/dailys/{id}/{password}")
    public Long updateDaily(@PathVariable("id") Long id, @PathVariable("password") String password, @RequestBody DailyRequestDto requestDto) {
        return dailyService.updateDaily(id, password, requestDto);
    }

    @DeleteMapping("/dailys/{id}/{password}")
    public Long deleteDaily(@PathVariable("id") Long id, @PathVariable("password") String password) {
        return dailyService.deleteDaily(id, password);
    }
}
