package in.ashokit.controller;

import in.ashokit.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    LoginService service;


    @GetMapping(value = "/login")
    public  String  getLoginPage(){
        return "Login";
    }
    @PostMapping(value = "/check")
    public String checkLogin(@RequestParam String username, @RequestParam String password, Model model){
        boolean status = service.authenticate(username,password);
        if (status) {
            model.addAttribute("username",username);
            return "Success";
        }
        else {
            model.addAttribute("message","Username/Password is incorrect");
            return "Login";
        }
    }


}
