package com.sparta.daily.repository;

import com.sparta.daily.entity.Daily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyRepository extends JpaRepository<Daily, Long> {
    List<Daily> findAllByOrderByModifiedAtDesc();
}
