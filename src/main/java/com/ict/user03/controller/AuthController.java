package com.ict.user03.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.user03.jwt.JWTUtil;
import com.ict.user03.service.AuthService;
import com.ict.user03.service.FreeBoardService;
import com.ict.user03.service.MyUserDetailsService;
import com.ict.user03.service.UsersService;
import com.ict.user03.vo.DataVO;
import com.ict.user03.vo.FreeBoardVO;
import com.ict.user03.vo.MembersVO;
import com.ict.user03.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @Autowired
    private FreeBoardService freeBoardService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;


    @PostMapping("/login")
    public ResponseEntity<DataVO> postMethodName(@RequestBody MembersVO mvo) {
         DataVO dataVO = authService.authenticate(mvo);
         if(dataVO != null){
            return ResponseEntity.ok(dataVO);
         }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
         }
       
    }
    
    

    @GetMapping("/detail")
    public FreeBoardVO getGuestDetail(@RequestParam("idx") Integer idx){
        return freeBoardService.getGuestDetail(idx);
    }
    
    
    @GetMapping("/userInfo")
    public ResponseEntity<UserVO> getUserInfo(@RequestParam("token") String token) throws Exception {
        // 토큰 가지고 id를 추출
        System.out.println("여기오민ㅇ?");
        String id = jwtUtil.extractUsername(token);
        // 추출한 id로 사용자 정보 추출
        UserVO user = userDetailsService.getUserDetail(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


}
