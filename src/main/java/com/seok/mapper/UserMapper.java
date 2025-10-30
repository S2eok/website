package com.seok.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.seok.dto.User;

public interface UserMapper {

	/** 로그인 */
	User login(@Param("userId") String userId, @Param("password") String password);

	/** 회원가입 */
	int signup(User user);

	/** 정보 수정 */
	int updateUser(User user);

	/** 회원 단일 조회 */
	User selectUserProfile(int userNum);

	/** 비밀번호 변경 */
	int updatePassword(User user);

	/** 마지막 로그인 시간 갱신 */
	int updateLastLogin(User user);

	/** 전체 회원 조회 */
	List<User> selectAllUsers(User user);

	/** 상태 변경 (관리자용) */
	int updateStatus(Map<String, Object> map);

}
