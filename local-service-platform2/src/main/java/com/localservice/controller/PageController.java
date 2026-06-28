package com.localservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // ✅ Only booking page (protected)
    @GetMapping("/booking/{id}")
    public String bookingPage(HttpSession session) {

        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        return "booking";
    }
}