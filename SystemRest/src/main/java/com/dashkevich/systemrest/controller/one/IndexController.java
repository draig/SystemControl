package com.dashkevich.systemrest.controller.one;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/one/")
public class IndexController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
