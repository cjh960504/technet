package com.vrenti.technet.service;

import com.vrenti.technet.repository.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberSerivce{

    public final MemberMapper memberMapper;

    @Override
    public int createMember() {
        return 0;
    }
}
