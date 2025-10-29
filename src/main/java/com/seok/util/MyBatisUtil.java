package com.seok.util;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            System.out.println("mybatis 초기화 성공");
        } catch (Exception e) {
        	System.out.println("mybatis 초기화 실패");
            e.printStackTrace();
        }
    }

    // 이자식 뭔지 모르겠음 오류 해결해달라고 유료친구한테 물어보니까 이거 넣으래....
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession(true); // auto-commit
    }
}