package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationController {

    @GetMapping("/report/{cno}/{cname}")
    public ResponseEntity<String> showDetials(
            @PathVariable("cno") int cno,
            @PathVariable("cname") String cname) {

        System.out.println(cno + " .. " + cname);
        return new ResponseEntity<>(cno + "...." + cname, HttpStatus.OK);
    }
}