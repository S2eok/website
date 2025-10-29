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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectAllBoards(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
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
	public int increaseViews(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countBoards(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}






}
