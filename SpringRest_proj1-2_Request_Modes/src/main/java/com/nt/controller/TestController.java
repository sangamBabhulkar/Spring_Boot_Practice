package com.nt.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    // GET
    @GetMapping("/select")
    public ResponseEntity<String> selectOp() {
        return new ResponseEntity<>("Select operation", HttpStatus.OK);
    }

    // POST
    @PostMapping("/add")
    public ResponseEntity<String> addOp() {
        return new ResponseEntity<>("Add operation", HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOp() {
        return new ResponseEntity<>("Delete operation", HttpStatus.NO_CONTENT);
    }

    // Season API
    @GetMapping("/season")
    public ResponseEntity<String> getSeason() {

        String season;
        LocalDate ld = LocalDate.now();
        int month = ld.getMonthValue();

        if (month >= 7 && month <= 10)
            season = "Rainy Season";
        else if (month >= 3 && month <= 6)
            season = "Summer";
        else
            season = "Winter";

        return new ResponseEntity<>(season, HttpStatus.OK);
    }
}