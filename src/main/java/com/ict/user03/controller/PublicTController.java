package com.ict.user03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.user03.service.PublicTService;
import com.ict.user03.vo.TradeVO;

@RestController
@RequestMapping("/api")
public class PublicTController {
    
    @Autowired
    private PublicTService publicTService;
    
    @GetMapping("/public")
    public String tradeList(){
        return null;
    }
    

}
