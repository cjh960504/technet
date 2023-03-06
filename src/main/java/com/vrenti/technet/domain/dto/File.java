package com.vrenti.technet.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class File {
    private int fileId;

    private int board_id;

    private int memberId;

    private String orgName;

    private String regName;

    private String type;

    private int size;

    private Date uploadDate;

    private String uploadIp;

    private int useAt;

    private char imageAt;


}
