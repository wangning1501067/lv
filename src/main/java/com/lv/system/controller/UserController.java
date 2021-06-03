package com.lv.system.controller;

import com.lv.system.model.Account;
import com.lv.system.common.BaseController;
import com.lv.system.model.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController extends BaseController {
    @GetMapping(value="/login")
    public String Login() {
        return "login";
    }

    @PostMapping("/login_submit")
    public String Valid(@Valid LoginUser loginUser) {
        boolean b = verUser(loginUser);
        if (b) {
            return "Login Success!";
        }
        return "Login Fail";
    }
}
