package com.example.demo.src.bookmark.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
    List<Bookmark> findByUserIdxAndStatusOrderByCreatedAt(Long userIdx, String status);
}
