package com.localservice.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String bookingDate;
    private String serviceType;
    private String status;
    private String timeSlot;

    // 🔥 Relation with User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 🔥 Relation with Partner
    @ManyToOne
    @JoinColumn(name = "partner_id")
    private ServicePartner partner;

    public Long getId() { return id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public ServicePartner getPartner() { return partner; }
    public void setPartner(ServicePartner partner) { this.partner = partner; }
}