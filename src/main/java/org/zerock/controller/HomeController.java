package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@Log4j2
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mv) {
        mv.addObject("Title", "Home");
        mv.addObject("Content", "Hello World.");
        mv.setViewName("index");
        return mv;
    }
}
