package org.zerock.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

@Log4j2
@Controller
public class LoginController {

    @Setter(onMethod_ = @Autowired)
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView loginGET(ModelAndView mv) throws Exception {
        mv.addObject("Title", "Login");
        mv.addObject("Content", "Login");
        mv.setViewName("login");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView loginPOST(ModelAndView mv, UserVO user) throws NullPointerException {
        try {
            // Checking Invalid Account
            UserVO userVO = userService.getUser(user.getUserId());
            if (userVO == null)
                throw new NullPointerException("This account does not exist.");
            mv.addObject("USER", userVO);
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
