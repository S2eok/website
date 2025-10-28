package com.seok.mapper;

import java.util.List;
import java.util.Map;
import com.seok.dto.User;

public interface UserMapper {

		// 로그인
		User login(User user);
		
		// 회원가입
		int signup(User user);
		
		// 정보 수정
		int updateUser(User user);
		
		// 회원 단일 조회
		User selectUserProfile(int userNum);
		
		// 비밀번호 변경
		int updatePassword(User user);
		
		// 마지막 로그인
		int updateLastLogin(User user);
		
		// 전체 회원 조회
		List<User> selectAllUsers();
		
		// 상태 변경 (관리자용)
		int updateStatus(Map<String, Object> map);
		
}
