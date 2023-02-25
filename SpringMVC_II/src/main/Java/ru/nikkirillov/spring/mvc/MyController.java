package ru.nikkirillov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

    //@RequestMapping(path = "/showDetails", method = RequestMethod.GET) тоже самое что ниже
    @GetMapping("/showDetails")
    public String showEmpDetailsView(@Valid @ModelAttribute(name = "employee") Employee emp,
                                     BindingResult result) {
        // show dynamic page (using annotation @ModelAttribute with @Valid for validation)
        // BindingResult - consists all errors

        System.out.println("sirname length " + emp.getSirname().length());

        if (result.hasErrors())
            return "ask-emp-details-view";
        else
            return "show-emp-details-view";
    }

}
