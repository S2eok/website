package com.seok.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.seok.dto.Board;
import com.seok.mapper.BoardMapper;
import com.seok.util.MyBatisUtil;

public class BoardServiceImpl implements BoardService {

	private static BoardService instance = new BoardServiceImpl();

	private BoardServiceImpl() {} // 외부에서 new 못하게 막기

	public static BoardService getInstance() {
		return instance;
	}

	@Override
	public int insertBoard(Board board) {
        try (SqlSession session = MyBatisUtil.openSession()) { // 세션 열기
        	BoardMapper mapper = session.getMapper(BoardMapper.class); // 여기서 mapper 객체 꺼내기
        	// 근데 이거 유료친구가 알려준거라 실무자 눈에는 괴상할수도....
        	 int result = mapper.insertBoard(board);
             session.commit(); // INSERT니까 반드시 commit 필요
             return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("게시글 올리다 오류난 듯");
            return 0;
        }
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Board selectBoardById(int boardId) {
        try (SqlSession session = MyBatisUtil.openSession()) { // 세션 열기
        	BoardMapper mapper = session.getMapper(BoardMapper.class); // 여기서 mapper 객체 꺼내기
             return mapper.selectBoardById(boardId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("게시글 상세 조회하다 오류난 듯");
            return null;
        }
	}

	@Override
	public List<Board> selectAllBoards() {
        try (SqlSession session = MyBatisUtil.openSession()) { // 세션 열기
        	BoardMapper mapper = session.getMapper(BoardMapper.class); // 여기서 mapper 객체 꺼내기
             return mapper.selectAllBoards();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("게시글 목록 불러오려다 오류난 듯");
            return null;
        }
	}

	@Override
	public List<Board> searchBoards(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePinnedStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int increaseViews(int boardId) {
        try (SqlSession session = MyBatisUtil.openSession()) { // 세션 열기
        	BoardMapper mapper = session.getMapper(BoardMapper.class); // 여기서 mapper 객체 꺼내기
             return mapper.increaseViews(boardId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("조회수 불러오려다 오류난 듯");
            return 0;
        }
	}

	@Override
	public int countBoards(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}
}