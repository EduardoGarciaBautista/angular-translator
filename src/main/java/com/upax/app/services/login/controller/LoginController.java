package com.upax.app.services.login.controller;

import com.upax.app.data.dto.RequestLogin;
import com.upax.app.data.dto.ResponseLogin;
import com.upax.app.services.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("loginUsuario")
    public ResponseLogin loginUsuario(@RequestBody RequestLogin requestLogin) {
        return loginService.loguearUsuario(requestLogin);
    }
}
