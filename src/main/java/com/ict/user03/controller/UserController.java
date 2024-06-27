package com.ict.user03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ict.user03.service.UsersService;
import com.ict.user03.vo.MembersVO;
import com.ict.user03.vo.UserVO;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UsersService usersService;

    @PostMapping("/joinUser")
    public int joinUser(@RequestBody UserVO uvo) {
        int result = usersService.joinUser(uvo);
        return result;
    }

    @PostMapping("/updateUserInfo")
    public int updateUserInfo(@RequestBody MembersVO mvo){
        int result = usersService.updateUserInfo(mvo);
        return result;
    }

    @PostMapping("/changePassword")
    public int changePassword(@RequestBody MembersVO mvo){
        int result = usersService.changePassword(mvo);
        return result;
    }
    
    @PostMapping("/withdrawUser")
    public int withdrawUser(@RequestParam("idx") Integer idx){
        int result = usersService.withdrawUser(idx);
        return result;
    }












}
