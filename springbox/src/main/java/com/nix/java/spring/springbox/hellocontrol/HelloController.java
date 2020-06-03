package com.nix.java.spring.springbox.hellocontrol;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(
        @RequestParam(name = "first-name", defaultValue = "world") String firstName,
        @RequestParam(name = "last-name", defaultValue = "") String lastName,
        Model model
    ){
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        return "hello";
    }
}
