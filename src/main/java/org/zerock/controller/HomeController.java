package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@Log4j2
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mv, HttpServletRequest request) {
        if (request.getSession().getAttribute("USER") == null) {
            mv.addObject("Title", "Home");
            mv.addObject("Content", "Hello.");
        }
        else {
            log.info(request.getSession().getAttribute("USER"));
        }
        mv.setViewName("index");
        return mv;
    }

}

