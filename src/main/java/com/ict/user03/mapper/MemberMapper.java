package com.ict.user03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.ict.user03.vo.FreeBoardVO;
import com.ict.user03.vo.MembersVO;
import com.ict.user03.vo.TradeVO;
import com.ict.user03.vo.UserVO;

@Mapper
public interface MemberMapper {
    /* user */
    UserVO selectMember(@Param("id") String id) ;
    UserVO findUserByEmail(@Param("email") String email);
    void insertUser(UserVO uvo);
    void updateUser(UserVO uvo);
    int joinUser(UserVO uvo);
    int updateUserInfo(MembersVO mvo);
    int changePassword(MembersVO mvo);
    int withdrawUser(@Param("idx") Integer idx);


    /* free */
    List<FreeBoardVO> getGuestList();
    FreeBoardVO getGuestDetail(@Param("idx") Integer idx);
    FreeBoardVO getGuestDetail(@Param("idx") String idx);
    int writeFreeboard(FreeBoardVO fvo);
    int updateFreeboard(FreeBoardVO fvo);
    int deleteFreeboard(@Param("idx") Integer idx);

    /* trade */
    List<TradeVO> tradeList();
    TradeVO detailTrade(@Param("idx") Integer idx);
    int writeTrade(TradeVO tvo);
    int updateTrade(TradeVO tvo);
    int deleteTrade(@Param("idx") Integer idx);
}
