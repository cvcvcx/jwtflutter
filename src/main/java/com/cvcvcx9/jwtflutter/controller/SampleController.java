package com.cvcvcx9.jwtflutter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/")
@Slf4j
public class SampleController {

    @GetMapping("/all")
    public void exAll(){
        log.info("exall......................");
    }

    @GetMapping("/member")
    public void exMember(){
        log.info("exmember......................");
    }

    @GetMapping("/admin")
    public void exAdmin(){
        log.info("exAdmin......................");
    }

}
