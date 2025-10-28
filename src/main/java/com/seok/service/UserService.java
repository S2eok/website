package com.seok.service;

import java.util.List;
import java.util.Map;
import com.seok.dto.User;

public interface UserService {

	// int 행 가져오는 놈 - 주로 수정, 삭제, 삽입
	// User 객체 가져오는 놈 - 주로 조회
	
    // 로그인
    User login(String userId, String password);

    // 회원가입
    int signup(User user);

    // 회원 정보 수정
    int updateUser(User user);

    // 회원 단일 조회
    User selectUserProfile(int userNum);

    // 비밀번호 변경
    int updatePassword(User user);

    // 마지막 로그인 갱신
    int updateLastLogin(User user);

    // 전체 회원 조회 (관리자용)
    List<User> selectAllUsers(User user);

    // 상태 변경
    int updateStatus(User user);
}
