package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

@Controller
@RequestMapping(value = "/user/*")
@AllArgsConstructor
@Log4j2
public class UserController {

    private UserService userService;

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
}
