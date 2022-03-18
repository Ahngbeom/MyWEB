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

    @GetMapping("/list")
    public ModelAndView list(ModelAndView mv) {
        userService.getUserList().forEach(user -> log.info(user));
        mv.addObject("user", userService.getUserList());
        mv.setViewName("user/list");
        return (mv);
    }

    @GetMapping("/info")
    public ModelAndView info(ModelAndView mv, String userId) throws NullPointerException {
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

    @PostMapping("/registerProcess")
    public ModelAndView registerPOST(ModelAndView mv, UserVO user) {
        if (userService.registerUser(user) == 1)
            log.info("User Register SUCCESS");
        else
            log.error("User Register FAILURE");
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/modify")
    public ModelAndView modifyGET(ModelAndView mv) {
        mv.addObject("Title", "Update User");
        mv.addObject("Content", "Update User");
        mv.setViewName("user/modify");
        return mv;
    }

    @PostMapping("/modifyProcess")
    public ModelAndView modifyPOST(ModelAndView mv, UserVO user, String checkPw) {
        if (userService.modifyUserInfo(user, checkPw) == 1) {
            log.info("User Modify SUCCESS");
            mv.setViewName("index");
        }
        else {
            log.error("User Modify FAILURE");
            mv.setViewName("user/modify");
        }
        return mv;
    }

    @GetMapping("/remove")
    public ModelAndView removeGET(ModelAndView mv) {
        mv.addObject("Title", "Remove User");
        mv.addObject("Content", "Remove User");
        mv.setViewName("user/remove");
        return mv;
    }

    @PostMapping("/removeProcess")
    public ModelAndView removePOST(ModelAndView mv, UserVO user, String checkPw) {
        if (userService.removeUser(user, checkPw) == 1) {
            log.info("User Remove SUCCESS");
            mv.setViewName("index");
        }
        else {
            log.error("User Remove FAILURE");
            mv.setViewName("user/remove");
        }
        return mv;
    }

}
