package org.zerock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.UserVO;
import org.zerock.service.LoginService;
import org.zerock.service.UserService;

@Controller
@RequiredArgsConstructor // 특정 변수만을 활용하는 생성자를 자동완성 시켜주는 어노테이션
@Log4j2
public class LoginController {

    private final UserService userService;
    private final LoginService loginService;

    @GetMapping("/login")
    public ModelAndView loginGET(ModelAndView mv) throws Exception {
        mv.addObject("Title", "Login");
        mv.addObject("Content", "Login");
        mv.setViewName("login");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView loginPOST(ModelAndView mv, UserVO user) throws Exception {
        try {
            log.info(user);
            // Checking Invalid Account
            userService.getUser(user.getUserId());
//            if (userVO == null)
//                throw new NullPointerException("This account does not exist.");
            mv.addObject("USER", user);
            mv.addObject("Title", "Welcome to Home");
            mv.addObject("Content", "Welcome !");
            mv.setViewName("index");
            log.info("Login SUCCESS");
        } catch (Exception e) {
            log.info(e.getMessage());
            mv.addObject("Title", "Login");
            mv.addObject("Content", e.getMessage());
        }
        return mv;
    }
}
