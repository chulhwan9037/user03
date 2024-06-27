package com.ict.user03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ict.user03.mapper.MemberMapper;
import com.ict.user03.vo.MembersVO;
import com.ict.user03.vo.UserVO;

@Service
public class UsersService {
    
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public int joinUser(UserVO uvo){

        String pwd = passwordEncoder.encode(uvo.getPassword());
        uvo.setPassword(pwd);
        return memberMapper.joinUser(uvo);
    }

    public int updateUserInfo(MembersVO mvo){
        return memberMapper.updateUserInfo(mvo);
    }

    public int changePassword(MembersVO mvo){
        String pwd = passwordEncoder.encode(mvo.getPassword());
        mvo.setPassword(pwd);
        return memberMapper.changePassword(mvo);
    }

    public int withdrawUser(Integer idx){
        // 비밀번호 확인하기
        return memberMapper.withdrawUser(idx);
    }
}
