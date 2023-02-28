package com.vrenti.technet.service;

import com.vrenti.technet.domain.dto.Board;
import com.vrenti.technet.repository.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BoardServiceImplTest {
    @Autowired
    BoardMapper boardMapper;

    @Test
    void writeBoard() {
        Board board = new Board();

        board.setMemberId(1);
        board.setBoardType("공지사항");
        board.setSubject("test");
        board.setContent("<p>test</p>");

        int result = boardMapper.writeBoard(board);
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(1);
        //Assertions.assertEquals(boardMapper.writeBoard(board), 1);
    }

    @Test
    void findByBoardId(){
        int boardId = 1;
        org.assertj.core.api.Assertions.assertThat(boardMapper.findByBoardId(boardId).getBoardId()).isEqualTo(1);
    }
}