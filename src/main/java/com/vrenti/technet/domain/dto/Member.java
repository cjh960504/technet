package com.vrenti.technet.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Member {
    private int memberId;

    private String id;

    private String password;

    private String name;

    private MemberRole role;

    private Date createDate;

    private String createIp;

    private Date updateDate;

    private String updateIp;

    private MemberStatus memberStatus;
}
