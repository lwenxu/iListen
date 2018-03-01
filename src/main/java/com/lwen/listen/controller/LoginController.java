package com.lwen.listen.controller;

import com.lwen.listen.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("elogin/username/{username}/password/{password}")
    public String elogin(@PathVariable String username,
                         @PathVariable String password) throws Exception {
        return loginService.elogin(username, password);
    }

    @GetMapping("clogin/username/{username}/password/{password}")
    public String clogin(@PathVariable String username,
                         @PathVariable String password) throws Exception {
        return loginService.clogin(username, password);
    }

    @GetMapping("/subcoun/id/{id}")
    public String subcoun(@PathVariable String id) {
        return loginService.subcoun(id);
    }
}
