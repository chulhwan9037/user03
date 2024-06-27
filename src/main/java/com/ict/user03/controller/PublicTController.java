package com.ict.user03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.user03.service.PublicTService;

@RestController
@RequestMapping("/api")
public class PublicTController {
    
    @Autowired
    private PublicTService publicTService;
    
    

}
