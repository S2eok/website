package com.seok.service;

import org.apache.ibatis.session.SqlSession;

import com.seok.dto.Like;
import com.seok.mapper.LikeMapper;
import com.seok.util.MyBatisUtil;

public class LikeServiceImpl implements LikeService {

	private static LikeService instance = new LikeServiceImpl();

	private LikeServiceImpl() {} // 외부에서 new 못하게 막기

	public static LikeService getInstance() {
		return instance;
	}

	// 기본 동작 (토글이 내부에서 이걸 호출함)
	@Override
	public int insertLike(Like like) {
        try (SqlSession session = MyBatisUtil.openSession()) { // 세션 열기
        	LikeMapper mapper = session.getMapper(LikeMapper.class); // 여기서 mapper 객체 꺼내기
        	 int result = mapper.insertLike(like);
        	 if(result > 0) session.commit();
             return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("좋아요 하려다 오류난 듯");
            return 0;
        }
	}

	// 기본 동작 (토글이 내부에서 이걸 호출함)
	@Override
	public int deleteLike(Like like) {
        try (SqlSession session = MyBatisUtil.openSession()) { // 세션 열기
        	LikeMapper mapper = session.getMapper(LikeMapper.class); // 여기서 mapper 객체 꺼내기
        	 int result = mapper.deleteLike(like);
        	 if(result > 0) session.commit();
             return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("좋아요 취소하려다 오류난 듯");
            return 0;
        }
	}

	@Override
	public boolean checkUserLike(Like like) {
        try (SqlSession session = MyBatisUtil.openSession()) { // 세션 열기
        	LikeMapper mapper = session.getMapper(LikeMapper.class); // 여기서 mapper 객체 꺼내기
        	 int count = mapper.checkUserLike(like);
             return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("좋아요 여부 확인 중 오류난 듯");
            return false;
        }
	}

	@Override
	public int updateBoardLikeCount(int boardId) {
		return 0;
	}

	@Override
	public int updateCommentLikeCount(int commentId) {
		return 0;
	}
}
