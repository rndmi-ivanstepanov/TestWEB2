package ru.stepanov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", name + " " + surname);

        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam int a,
                            @RequestParam int b,
                            @RequestParam String action,
                            Model model) {
        double result;

        switch(action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double) b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            default:
                result = 0;
        }
        model.addAttribute("result", result).addAttribute("action", action);
        return "first/calculator";
    }
}
