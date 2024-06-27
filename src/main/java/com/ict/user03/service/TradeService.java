package com.ict.user03.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ict.user03.mapper.MemberMapper;
import com.ict.user03.vo.TradeVO;

@Service
public class TradeService {
    
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<TradeVO> tradeList(){
        return memberMapper.tradeList();
    }

    public TradeVO detailTrade(Integer idx){
        return memberMapper.detailTrade(idx);
    }

    public int writeTrade(TradeVO tvo, MultipartFile imageFile) throws IOException{
        String pwd = passwordEncoder.encode(tvo.getPw());
        tvo.setPw(pwd);
        if(!imageFile.isEmpty()){
            tvo.setImage(imageFile.getBytes());
            tvo.setImage_size(imageFile.getSize());
            tvo.setImage_format(imageFile.getContentType());
        }
        return memberMapper.writeTrade(tvo);
    }


    public int updateTrade(TradeVO tvo, MultipartFile imagFile) throws IOException{
        // 비번 확인 멀티파트파일
        return memberMapper.updateTrade(tvo);
    }

    public int deleteTrade(Integer idx){
        // 비번 확인
        return memberMapper.deleteTrade(idx);
    }
}
