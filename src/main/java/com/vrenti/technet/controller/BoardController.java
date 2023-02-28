package com.vrenti.technet.controller;

import com.vrenti.technet.domain.dto.Board;
import com.vrenti.technet.domain.dto.BoardType;
import com.vrenti.technet.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board/{boardId}")
    public Board findByBoardId(@PathVariable("boardId") int boardId){
        return boardService.findByBoardId(boardId);
    }

    @PostMapping("/board")
    public int writeBoard(@RequestBody Board board){
        return boardService.writeBoard(board);
    }

    @GetMapping("/board/{boardType}/")
    public List<Board> findBoardList(@PathVariable("boardType") int boardType,
                                     @RequestParam(name="keyword", required = false) String keyword){
        return boardService.findBoardList(boardType, keyword);
    }

    @PutMapping("/board/{boardId}")
    public int editBoard(@PathVariable("boardId") int boardId, @RequestBody Board board){
        board.setBoardId(boardId);
        return boardService.updateBoard(board);
    }

    @DeleteMapping("/board/{boardId}")
    public String deleteBoard(@PathVariable("boardId") int boardId){
        return "";
    }

}
