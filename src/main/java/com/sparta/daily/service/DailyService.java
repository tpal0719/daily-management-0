package com.sparta.daily.service;

import com.sparta.daily.util.DailyUtils;
import com.sparta.daily.dto.DailyRequestDto;
import com.sparta.daily.dto.DailyResponseDto;
import com.sparta.daily.entity.Daily;
import com.sparta.daily.repository.DailyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyService {
    private final DailyRepository dailyRepository;

    private final DailyUtils dailyUtils= new DailyUtils();

    public DailyService(DailyRepository dailyRepository) {
        this.dailyRepository = dailyRepository;
    }

    // 1. 일정 작성
    public DailyResponseDto writeDaily(DailyRequestDto requestDto) {
        // RequestDto -> Entity
        Daily daily = new Daily(requestDto);
        // DB 저장
        Daily saveDaily = dailyRepository.save(daily);
        // Entity -> ResponseDto
        DailyResponseDto dailyResponseDto = new DailyResponseDto(daily);
        return dailyResponseDto;
    }


    // 2. 선택 할일 조회
    public DailyResponseDto getDailyById(Long id) {
        return new DailyResponseDto(dailyUtils.findDaily(id,dailyRepository));
    }

    // 3. 일정 목록 조회
    public List<DailyResponseDto> getAllDailys() {
        // DB 조회
        return dailyRepository.findAllByOrderByModifiedAtDesc().stream().map(DailyResponseDto::new).toList();
    }

    // 4. 선택한 일정 수정
    @Transactional
    public Long updateDaily(Long id, String password, DailyRequestDto requestDto) {
        Daily daily = dailyUtils.findDaily(id,dailyRepository);;
        if (daily.getPassword().equals(password)) {
            daily.update(requestDto);
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }


        return id;
    }

    // 5. 선택한 일정 삭제
    public Long deleteDaily(Long id, String password) {
        Daily daily = dailyUtils.findDaily(id,dailyRepository);
        if (daily.getPassword().equals(password)) {
            dailyRepository.delete(daily);
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }

        return id;
    }



}