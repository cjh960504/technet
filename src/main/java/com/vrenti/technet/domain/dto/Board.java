package com.vrenti.technet.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Board {
    private int boardId;

    private int memberId;

    private int boardType;

    private String boardSecret; //String 말구

    private String boardPassword;

    private String subject;

    private String content;

    private Date writeDate;

    private String writeIp;

    private Date editDate;

    private String editIp;

    private int hit;

    private String boardThumb;

}
