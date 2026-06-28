package com.localservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.localservice.model.Booking;
import com.localservice.model.User;
import com.localservice.repository.BookingRepository;
import com.localservice.repository.ServicePartnerRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ServiceController {

    @Autowired
    private ServicePartnerRepository servicePartnerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // ✅ Show services page
    @GetMapping("/services")
    public String services(Model model, HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");

        // 🔐 Protect page (VERY IMPORTANT)
        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("services", servicePartnerRepository.findAll());

        return "services";
    }

    // ✅ Show booking form
    @GetMapping("/booking/form/{partnerId}")
    public String bookingForm(@PathVariable Long partnerId,
                             Model model,
                             HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");

        // 🔐 Protect booking page
        if (user == null) {
            return "redirect:/login";
        }

        Booking booking = new Booking();
        booking.setPartnerId(partnerId);

        model.addAttribute("booking", booking);

        return "booking-form";
    }
}