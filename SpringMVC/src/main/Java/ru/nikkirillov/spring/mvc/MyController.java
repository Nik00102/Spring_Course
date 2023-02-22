package ru.nikkirillov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }

    /*@RequestMapping("/showDetails")
    public String showEmpDetailsView() {  // show static page (without parameters)
        return "show-emp-details-view";
    }*/

   /* @RequestMapping("/showDetails")
    public String showEmpDetailsView(HttpServletRequest httpServletRequest, Model model) {  // show dynamic page (with parameters HttpServletRequest)
        String empName = httpServletRequest.getParameter("employeeName");
        empName = "Java programmer " + empName;

        model.addAttribute("nameAttribute", empName);

        model.addAttribute("description", "- technical specialist -");

        return "show-emp-details-view";
    }*/

    @RequestMapping("/showDetails")
    public String showEmpDetailsView(@RequestParam(name = "employeeName") String empName, Model model) {  // show dynamic page (using annotation @RequestParam)
        empName = "Java programmer " + empName;

        model.addAttribute("nameAttribute", empName + "!");

        model.addAttribute("description", "- technical specialist -");

        return "show-emp-details-view";
    }

}
