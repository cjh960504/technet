package com.vrenti.technet.repository.sql;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class BoardSQL {

    public static final String FIND_BOARD = "SELECT * FROM BOARD WHERE BOARD_ID = #{boardId}";

    public static final String FIND_BOARDS = "SELECT * FROM BOARD WHERE BOARD_TYPE = #{boardType} ";
    public static final String INSERT_BOARD = "INSERT INTO BOARD(member_id, board_type, subject, content, write_date, write_ip, edit_date, edit_ip, hit) "
            + "VALUES (1, #{board.boardType}, #{board.subject}, #{board.content}, now(), '', now(), '', 1)";

    public static final String UPDATE_BOARD = "UPDATE BOARD SET BOARD_TYPE = #{board.boardType}, BOARD_SECRET = #{board.boardSecret}," +
            "BOARD_PASSWORD = #{board.boardPassword}, SUBJECT = #{board.subject}, CONTENT = #{board.content}, EDIT_DATE = now(), EDIT_IP = ''," +
            "BOARD_THUMB = #{board.boardThumb} WHERE BOARD_ID = #{board.boardId}";

    public String findBoardsByKeywordInBoardType(String keyword){
        //BoardType 은 컨트롤러에서 필수로 체크해야하는 부분
        //BoardType 이 varchar(10) 으로 되어있어서 검색이 안되는 상황 발생했었음

        StringBuilder query = new StringBuilder();

        query.append(FIND_BOARDS);

        if(StringUtils.hasText(keyword)){
            query.append("AND (SUBJECT LIKE concat('%', #{keyword}, '%') OR CONTENT LIKE concat('%', #{keyword}, '%'))");
        }

        return query.toString();
    }
}