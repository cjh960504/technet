package com.vrenti.technet.service;

import com.vrenti.technet.domain.dto.Board;

import java.util.List;

public interface BoardService {

    public int writeBoard(Board board);

    public Board findByBoardId(int boardId);

    public List<Board> findBoardList(int boardType, String keyword, int pageNum, int pageSize, String searchType);

    public int updateBoard(Board board);

    public int deleteBoard(int boardId);
}
