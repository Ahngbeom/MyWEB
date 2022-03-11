package org.zerock.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

@Controller
@RequestMapping(value = "/user/*")
@Log4j2
public class UserController {

    private UserService userService;

    @GetMapping("/info")
    public ModelAndView info(ModelAndView mv, UserVO dto) {
        System.out.println(dto);
        UserVO user = userService.getUser(dto.getUserId());
        System.out.println(user);
        mv.addObject("user", user);
        return (mv);
    }
}
