package com.example.registrationlogindemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController //rest é quando tem integração, envia info e/ou recebe (em formato json)
@RequestMapping("/api")
public class CookiesRestController {

    @RequestMapping("/set-preference")
    public String setPreference(HttpServletResponse response) {
        Cookie preferenceCookie = new Cookie("preference", "darkMode");
        preferenceCookie.setMaxAge(30 * 24 * 60 * 60); // Define a expiração do cookie (30 dias)
        response.addCookie(preferenceCookie);
        return "Preferencias definidas!";
    }

    @RequestMapping("/get-preference")
    public String dashboard(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) { //percorre ate que exista o obj cookie
                if ("preference".equals(cookie.getName())) {
                    String preference = cookie.getValue();
                    return preference;
                }
            }
        }
        return "Não existe cookies";
    }
}
