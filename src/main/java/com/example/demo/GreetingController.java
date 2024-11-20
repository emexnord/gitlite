package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/test")
public class GreetingController {
    
    @GetMapping
    public ModelAndView getTestData() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        mv.getModel().put("data", "welcome home man");

        return mv;
    }

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "welcome"; // Refers to welcome.html in the templates folder
    }

}
