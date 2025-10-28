package com.seok.service;

import java.util.List;
import java.util.Map;

import com.seok.dto.Board;

// 역할: “비즈니스 로직(업무 처리)” 담당
// controller에서 받은 요청 데이터를 가지고 실제 로직을 수행
// 예: 로그인 검증, 회원가입 처리, 포인트 계산, 트랜잭션 관리 등
// DB 접근은 직접 하지 않고, mapper나 repository를 호출해서 DB 처리 위임

public interface BoardService {

		// 게시글 등록
		int insertBoard(Board board);

		// 게시글 수정
		int updateBoard(Board board);

		// 게시글 수정
		int deleteBoard(Map<String, Object> map);

		// 게시글 하나 조회
		Board selectBoardById(int boardId);

		// 게시글 목록 조회
		List<Board> selectAllBoards(Map<String, Object> map);
				
		// 게시글 검색
		List<Board>	searchBoards(Map<String, Object> map);
				
		// 핀 상태 변경 (관리자용)
		int updatePinnedStatus(Map<String, Object> map);

		// 조회수 증가 
		int increaseViews(Board board);

		// 게시글 수 카운트 (페이징용)
		int countBoards(Map<String, Object> map);
}
