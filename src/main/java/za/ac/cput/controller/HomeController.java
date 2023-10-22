package za.ac.cput.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {


    @RequestMapping("/")
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:3000");
        return redirectView;
    }

    @RequestMapping("/welcome")
    public RedirectView welcomeRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:3000");
        return redirectView;
    }

//    @GetMapping("/")
//    public String getOpen() {
//        return "homePage";
//    }

//    @GetMapping("/home")
//    public String getHomePage() {
//        return "";
//    }


    @GetMapping("/admin")
    public String getAdminPage() {
        return "adminPage";
    }

    @GetMapping("/painter")
    public String getPainterPage() {
        return "painterPage";
    }

    @GetMapping("/common")
    public String getCommonPage() {
        return "commonPage";
    }

    @GetMapping("/accessDenied")
    public String getAccessDeniedPage() {
        return "accessDeniedPage";
    }
}
