package com.localservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.localservice.model.Booking;
import com.localservice.model.ServicePartner;
import com.localservice.model.User;
import com.localservice.repository.BookingRepository;
import com.localservice.repository.ServicePartnerRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ServicePartnerRepository servicePartnerRepository;

    @PostMapping("/booking/create")
    public String createBooking(@ModelAttribute Booking booking, HttpSession session){

        User user = (User) session.getAttribute("loggedUser");

        if(user == null){
            return "redirect:/login";
        }

        ServicePartner partner = servicePartnerRepository
                .findById(booking.getPartner().getId())
                .orElseThrow();

        booking.setUser(user);
        booking.setPartner(partner);
        booking.setCustomerName(user.getName());
        booking.setServiceType(partner.getServiceType());
        booking.setStatus("PENDING");

        bookingRepository.save(booking);

        return "redirect:/services";
    }
}