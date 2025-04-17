package com.example.app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class CustomErrorController implements ErrorController {
     @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute("jakarta.servlet.error.status_code");
        model.addAttribute("status", status);
        return "error"; // templates/error.html を表示
    }
    
}
