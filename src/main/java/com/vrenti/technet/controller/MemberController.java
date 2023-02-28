package com.vrenti.technet.controller;

import com.vrenti.technet.service.MemberSerivce;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class MemberController {

    public final MemberSerivce memberSerivce;

    @ResponseBody
    @RequestMapping("/member")
    public String createMember(){ //@RequestBody Member member

        return "";
    }

}
