package com.seok.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.seok.dto.User;
import com.seok.mapper.UserMapper;
import com.seok.util.MyBatisUtil;

//@Service  // 스프링이 자동으로 Bean 등록
public class UserServiceImpl implements UserService {

	private static UserService instance = new UserServiceImpl();

	private UserServiceImpl() {} // 외부에서 new 못하게 막기

	public static UserService getInstance() {
		return instance;
	}

	// private UserMapper userMapper; // 얘가 왜 NULL이지 데구리 긁적긁적
	//Cannot invoke "com.seok.mapper.UserMapper.login(String, String)" because "this.userMapper" is null 뜸

	@Override
	public User login(String userId, String password) {
        try (SqlSession session = MyBatisUtil.openSession()) { // 세션 열기
            UserMapper mapper = session.getMapper(UserMapper.class); // 여기서 mapper 객체 꺼내기
            return mapper.login(userId, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("로그인 오류난 듯");
            return null;
        }
    }

	@Override
	public int signup(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectUserProfile(int userNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePassword(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLastLogin(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectAllUsers(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStatus(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
}
