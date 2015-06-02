package com.dashkevich.fullrestapi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/index")
    public String listContacts() {
        return "index";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }
}
