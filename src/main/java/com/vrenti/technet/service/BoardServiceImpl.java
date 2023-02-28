package com.vrenti.technet.service;

import com.vrenti.technet.domain.dto.Board;
import com.vrenti.technet.repository.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;


    @Override
    public int writeBoard(Board board) {
        Board board2 = new Board();

        board2.setMemberId(1);
        board2.setBoardType(1);
        board2.setSubject("test");
        board2.setContent("<p>test</p>");

        return boardMapper.writeBoard(board2);
    }

    @Override
    public Board findByBoardId(int boardId) {
        return boardMapper.findByBoardId(boardId);
    }

    @Override
    public List<Board> findBoardList(int boardType, String keyword) {
        return boardMapper.findBoardsByKeywordInBoardType(boardType, keyword);
    }

    @Override
    public int updateBoard(Board board) {
        return boardMapper.updateBoard(board);
    }
}
