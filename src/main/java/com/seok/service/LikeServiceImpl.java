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
        	// 근데 이거 유료친구가 알려준거라 실무자 눈에는 괴상할수도....
        	// 기능 없애.... 화면에서 확인 하고 여긴 실행만?
        	// 화면에서 누르면, 안눌린 상태면 누르는거 작동 아니면 취소시키기
        	// 여기서 확인할 필요가 읎다
        	// 라고 차님이 하심
        	// 스프링 부트 배우고 싶으면 싸피보다 김영한 쌤 인프런 강의를 들어봐라
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
            System.out.println("좋아요 하려다 오류난 듯");
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

	// 토글 (내부적으로 위 두 개를 이용)
	@Override
	public boolean toggleLike(Like like) {
        try (SqlSession session = MyBatisUtil.openSession()) { // 세션 열기
        	LikeMapper mapper = session.getMapper(LikeMapper.class); // 여기서 mapper 객체 꺼내기 
        	int count = mapper.checkUserLike(like);
        	boolean liked;
        	if(count > 0) {
        		mapper.deleteLike(like);
        		liked = false; 
        	} else {
        		mapper.insertLike(like);
        		liked = true; 
        	}
        	session.commit(); // INSERT니까 반드시 commit 필요
            return liked;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("좋아요 버튼 누르려다 오류난 듯");
            return false;
        }
	}
}
