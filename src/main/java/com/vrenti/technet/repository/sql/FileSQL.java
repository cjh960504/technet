package com.vrenti.technet.repository.sql;

public class FileSQL {

    public static final String INSERT_FILE = "INSERT INTO FILE (BOARD_ID, MEMBER_ID, ORG_NAME, REG_NAME, TYPE, SIZE, UPLOAD_DATE, UPLOAD_IP, USE_AT) " +
            "VALUES(NULL, #{file.memberId}, #{file.orgName}, #{file.regName}, #{file.type}, #{file.size}, now(), #{file.uploadIp}, #{file.useAt})";
}
