package com.example.demo.repository;

import com.example.demo.model.board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<board, Integer> {

    @Query("SELECT b FROM board b WHERE b.id = :boardId")
    List<board> findById(@Param("boardId") int boardId);
}
