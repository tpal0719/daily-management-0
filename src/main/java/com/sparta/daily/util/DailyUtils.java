package com.sparta.daily.util;

import com.sparta.daily.entity.Daily;
import com.sparta.daily.repository.DailyRepository;

public class DailyUtils {

    /* Utils */
    public Daily findDaily(Long id, DailyRepository dailyRepository) {
        return dailyRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 일정은 존재하지 않습니다."));
    }
}
