package edu.bit.ex.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;


@Log4j
@RequestMapping("/security/*")
@Controller
public class SecurityController {

    @GetMapping("/all")
    public void doAll() {
        log.info("do all can access everybody");
    }
    
    @GetMapping("/member")
    public void doMember() {
        log.info("logined member");
    }
    
    
    @GetMapping("/admin")
    public void doAdmin() {
        log.info("logined admin");
    }
    
	
    @GetMapping("/accessError")
    public void accessError(Authentication auth, Principal pi, Model model) {
        log.info("accessError()..." + auth);
        model.addAttribute("msg", "Access Denied");
    }
    
    
}
