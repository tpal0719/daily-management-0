package com.sparta.daily.repository;

import com.sparta.daily.entity.Comment;
import com.sparta.daily.entity.Daily;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
