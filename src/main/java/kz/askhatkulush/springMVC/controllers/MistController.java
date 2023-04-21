package kz.askhatkulush.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mist")
public class MistController {

    @RequestMapping("/heroes")
    public String getHeroes() {
        return "mist/heroes.html";
    }
}
