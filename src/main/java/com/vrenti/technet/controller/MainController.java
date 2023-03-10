package com.vrenti.technet.controller;

import com.vrenti.technet.repository.mapper.TestMapper;
import com.vrenti.technet.domain.vo.TestVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class MainController {
    private final TestMapper testMapper;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @ResponseBody
    @PostMapping("/test")
    public int insert(@RequestBody TestVO testVO){
        return testMapper.insert(testVO);
    }

    @ResponseBody
    @GetMapping("/test")
    public Object selectAll(){
        return testMapper.findAll();
    }

    @ResponseBody
    @GetMapping("/test/{id}")
    public TestVO selectOne(@PathVariable(name="id") int id){
        return testMapper.findById(id);
    }
}
