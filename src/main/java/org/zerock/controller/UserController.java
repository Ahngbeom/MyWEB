package org.zerock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

@Controller
@RequestMapping(value = "/user/*")
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @GetMapping("/info")
    public ModelAndView info(ModelAndView mv, String userId) throws NullPointerException{
        try {
            UserVO user = userService.getUser(userId);
            log.info(userService.getUser(userId));
            mv.addObject("user", user);
            mv.setViewName("user/info");
        } catch (Exception e) {
            log.info(e);
        }
        return (mv);
    }

    @GetMapping("/register")
    public ModelAndView registerGET(ModelAndView mv) {
        mv.addObject("Title", "User Register");
        mv.addObject("Content", "User Register");
        mv.setViewName("user/register");
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView registerPOST(ModelAndView mv, UserVO user) {
        if (userService.registerUser(user) == 1)
            log.info("User Register SUCCESS");
        else
            log.error("User Register FAILURE");
        mv.setViewName("user/register");
        return registerGET(mv);
    }
}
