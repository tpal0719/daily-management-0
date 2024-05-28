package com.sparta.daily.repository;

import com.sparta.daily.entity.Comment;
import com.sparta.daily.entity.Daily;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findAllByIdAndDailyId(Long id, Long dailyId);
}
