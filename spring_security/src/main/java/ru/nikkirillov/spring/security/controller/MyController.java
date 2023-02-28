package ru.nikkirillov.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/")
    public String getInfoForAllEmployees() {
        return "view_for_all_employees";
    }

    @GetMapping("/hrInfo")
    public String getInfoForHR() {
        return "view_for_hr";
    }

    @GetMapping("/managerInfo")
    public String getInfoForManagers() {
        return "view_for_managers";
    }
}
