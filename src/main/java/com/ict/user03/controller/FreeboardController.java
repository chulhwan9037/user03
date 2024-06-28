package com.ict.user03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ict.user03.service.FreeBoardService;
import com.ict.user03.vo.FreeBoardVO;

@RestController
@RequestMapping("/api")
public class FreeboardController {
    @Autowired
    private FreeBoardService freeBoardService;

    @GetMapping("/freeBoard")
    public List<FreeBoardVO> getGuestList() {
        return freeBoardService.getGuestList();
    }

    @GetMapping("/freeBoardDetail")
    public FreeBoardVO getGuestDetail(@RequestParam("idx") Integer idx){
        return freeBoardService.getGuestDetail(idx);
    }

    @PostMapping("/writeFreeboard")
    public int writeFreeboard(@RequestBody FreeBoardVO fvo){
        System.out.println("컨트롤러"+fvo.getId());
        int result = freeBoardService.writeFreeboard(fvo);
        return result;
    }

    @PostMapping("/updateFreeboard")
    public int updateFreeboard(@RequestBody FreeBoardVO fvo, @RequestParam("free_pw") String free_pw){
        int result = freeBoardService.updateFreeboard(fvo, free_pw);
        return result;
    }

    @PostMapping("/deleteFreeboard")
    public int deleteFreeboard(@RequestParam("idx") Integer idx){
        int result = freeBoardService.deleteFreeboard(idx);
        return result;
    }

    


}
