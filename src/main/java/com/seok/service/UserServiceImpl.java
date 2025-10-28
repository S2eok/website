package com.seok.service;

import java.util.List;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.seok.dto.User;
import com.seok.mapper.UserMapper;

//@Service  // 스프링이 자동으로 Bean 등록
public class UserServiceImpl implements UserService {

	@Override
	public User login(String userId, String password) {
		// TODO Auto-generated method stub
		return null;
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
	public List<User> selectAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStatus(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public User login(Map<String, Object> map) {
//        return userMapper.login(map);
//    }
//
//    @Override
//    @Transactional
//    public int signup(User user) {
//        return userMapper.signup(user);
//    }
//
//    @Override
//    @Transactional
//    public int updateUser(User user) {
//        return userMapper.updateUser(user);
//    }
//
//    @Override
//    public User selectUserProfile(int userNum) {
//        return userMapper.selectUserProfile(userNum);
//    }
//
//    @Override
//    @Transactional
//    public int updatePassword(User user) {
//        return userMapper.updatePassword(user);
//    }
//
//    @Override
//    @Transactional
//    public int updateLastLogin(User user) {
//        return userMapper.updateLastLogin(user);
//    }
//
//    @Override
//    public List<User> selectAllUsers() {
//        return userMapper.selectAllUsers();
//    }
//
//    @Override
//    @Transactional
//    public int updateStatus(Map<String, Object> map) {
//        return userMapper.updateStatus(map);
//    }
}
