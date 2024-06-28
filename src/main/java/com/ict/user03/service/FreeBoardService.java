package com.ict.user03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ict.user03.mapper.MemberMapper;
import com.ict.user03.vo.FreeBoardVO;

@Service
public class FreeBoardService {
     @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<FreeBoardVO> getGuestList(){
        return memberMapper.getGuestList();
    }

    public FreeBoardVO getGuestDetail(Integer idx){
        return memberMapper.getGuestDetail(idx);
    }

    public int writeFreeboard(FreeBoardVO fvo){
        System.out.println("서비스"+fvo.getPw());
        String pwd = passwordEncoder.encode(fvo.getPw());
        fvo.setPw(pwd);
        return memberMapper.writeFreeboard(fvo);
    }

    public int updateFreeboard(FreeBoardVO fvo, String free_pw){
        // 비밀번호 확인하기
        FreeBoardVO fvo2 = memberMapper.getGuestDetail(fvo.getIdx());
        String dpw = fvo2.getPw();
        if(passwordEncoder.matches(free_pw, dpw)){
            return memberMapper.updateFreeboard(fvo);
        }
        return -1;

    }

    public int deleteFreeboard(Integer idx){
        // 비밀번호 확인하기
        return memberMapper.deleteFreeboard(idx);
    }
}
