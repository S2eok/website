package com.seok.service;

import java.util.List;
import com.seok.dto.User;

public interface UserService {

    /** 
     * 로그인 
     * @param userId 사용자 아이디
     * @param password 사용자 비밀번호
     * @return 로그인 성공 시 User 객체, 실패 시 null
     */
    User login(String userId, String password);

    /** 
     * 회원가입 
     * @param user 회원 정보
     * @return 처리된 행 수 (1 = 성공)
     */
    int signup(User user);

    /** 
     * 회원 정보 수정 
     * @param user 수정할 회원 정보
     * @return 처리된 행 수
     */
    int updateUser(User user);

    /** 
     * 회원 단일 조회 
     * @param userNum 회원 번호
     * @return 해당 회원의 User 객체
     */
    User selectUserProfile(int userNum);

    /** 
     * 비밀번호 변경 
     * @param user 비밀번호가 포함된 회원 객체
     * @return 처리된 행 수
     */
    int updatePassword(User user);

    /** 
     * 마지막 로그인 시간 갱신 
     * @param user 회원 객체 (userNum 필수)
     * @return 처리된 행 수
     */
    int updateLastLogin(User user);

    /** 
     * 전체 회원 조회 (관리자용) 
     * @return 모든 회원 목록
     */
    List<User> selectAllUsers(User user);

    /** 
     * 회원 상태 변경 (관리자용) 
     * @param user 상태값이 포함된 회원 객체
     * @return 처리된 행 수
     */
    int updateStatus(User user);
}
