package com.example.demo.service;

import com.example.demo.model.board;
import com.example.demo.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class boardService {
    @Autowired
    private BoardRepository boardRepository;

    public List<board> findById(int boardId){
        return boardRepository.findById(boardId);
    }

    @Transactional
    public int save(board Board){
        try{
            boardRepository.save(Board);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("boardService 실패 : " + e.getMessage());
        }
        return -1;
    }
}