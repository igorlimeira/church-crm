package br.com.joy.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class LanguageController {

    @RequestMapping("/changeLanguage")
    public String changeLanguage(@RequestParam("lang") String language, HttpServletRequest request) {
        request.getSession().setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", new Locale(language));
        return "redirect:/faithful";
    }
}
