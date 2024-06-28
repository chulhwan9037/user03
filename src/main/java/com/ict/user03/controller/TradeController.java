package com.ict.user03.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ict.user03.service.TradeService;
import com.ict.user03.vo.TradeVO;

@RestController
@RequestMapping("/api")
public class TradeController {
    
    @Autowired
    private TradeService tradeService;

    @GetMapping("/tradeboard")
    public List<TradeVO> tradeList(){
        return tradeService.tradeList();
    }

    @GetMapping("/detailTrade")
    public TradeVO detailTrade(@RequestParam("idx") Integer idx){
        return tradeService.detailTrade(idx);
    }

    @PostMapping("/writeTrade")
    public int writeTrade(@RequestBody TradeVO tvo) throws IOException{
        System.out.println("컨트롤라"+tvo.getId());
        return tradeService.writeTrade(tvo);
    }

    @PostMapping("/updateTrade")
    public int updateTrade(@ModelAttribute TradeVO tvo, @RequestPart("imageFile") MultipartFile imageFile) throws IOException{
        return tradeService.updateTrade(tvo, imageFile);
    }

    @PostMapping("/deleteTrade")
    public int deleteTrade(@RequestParam("idx") Integer idx){
        int result = tradeService.deleteTrade(idx);
        return result; 
    }
}
