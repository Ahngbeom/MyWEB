package org.zerock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.UserVO;
import org.zerock.service.LoginService;
import org.zerock.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SessionAttributes("USER")
@Controller
@RequiredArgsConstructor // 특정 변수만을 활용하는 생성자를 자동완성 시켜주는 어노테이션
@Log4j2
public class LoginController {

    private final LoginService loginService;
    private final UserService userService;
    private final HomeController homeController;

    @GetMapping("/login")
    public String loginGET(HttpServletRequest request, ModelAndView mv) throws Exception {
//        mv.addObject("Title", "Login");
//        mv.setViewName("login/login");
        return "login/login";
    }

    @PostMapping("/loginProcess")
    public String loginPOST(HttpServletRequest request, RedirectAttributes rttr, UserVO user) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserVO validUser;
        try {
            // Checking Invalid Account
            if (loginService.identityCheck(user)) {
                validUser = userService.getUser(user.getUserId());
                request.getSession().setAttribute("USER", validUser);

//                mv.addObject("USER", validUser);
//                mv.addObject("Title", "Welcome to Home");
//                mv.addObject("Content", "Welcome!");
                rttr.addFlashAttribute("Title", "Welcome to Home");
                rttr.addFlashAttribute("Content", "Welcome to Home!");
//                mv.setViewName("redirect:/");

                log.info("Login SUCCESS");
            }
            else
                throw new NullPointerException("This account does not exist.");

        } catch (Exception e) {
            log.error(e.getMessage());
            mv.setViewName("login/login");
            mv.addObject("Title", "Login");
            mv.addObject("Content", e.getMessage());
            return "redirect:/login";
        }
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        request.getSession().removeAttribute("USER");
        return "redirect:/";
    }
}
