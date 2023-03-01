package com.vrenti.technet.repository.mapper;

import com.vrenti.technet.domain.dto.Board;
import com.vrenti.technet.repository.sql.BoardSQL;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    /*@Insert("INSERT INTO BOARD(member_id, board_type, subject, content, write_date, write_ip, edit_date, edit_ip, hit) "
            + "VALUES (1, #{board.boardType}, #{board.subject}, #{board.content}, now(), '', now(), '', 1)")
    public int writeBoard(@Param("board") Board board);

    @Select("SELECT * FROM BOARD WHERE BOARD_ID = #{boardId}")
    public Board findByBoardId(@Param("boardId") int boardId);

    @SelectProvider(type = BoardSQL.class, method = "findBoardsByKeywordInBoardType")
    public List<Board> findBoardsByKeywordInBoardType(@Param("boardType") int boardType, @Param("keyword") String keyword);

    @Update("UPDATE BOARD SET BOARD_TYPE = #{board.boardType}, BOARD_SECRET = #{board.boardSecret}," +
            "BOARD_PASSWORD = #{board.boardPassword}, SUBJECT = #{board.subject}, CONTENT = #{board.content}, EDIT_DATE = now(), EDIT_IP = ''," +
            "BOARD_THUMB = #{board.boardThumb} WHERE BOARD_ID = #{board.boardId}")
    public int updateBoard(@Param("board") Board board);*/

    @Insert(BoardSQL.INSERT_BOARD)
    public int writeBoard(@Param("board") Board board);

    @Select(BoardSQL.FIND_BOARD)
    public Board findByBoardId(@Param("boardId") int boardId);

    @SelectProvider(type = BoardSQL.class, method = "findBoardsByKeywordInBoardType")
    public List<Board> findBoardsByKeywordInBoardType(@Param("boardType") int boardType, @Param("keyword") String keyword,
                                                      @Param("pageNum") int pageNum,  @Param("pageSize") int pageSize, String searchType);

    @Update(BoardSQL.UPDATE_BOARD)
    public int updateBoard(@Param("board") Board board);

    @Update(BoardSQL.DELETE_BOARD)
    public int deleteBoard(@Param("boardId") int boardId);
}
