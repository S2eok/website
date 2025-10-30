package com.seok.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.seok.dto.Board;

public interface BoardMapper {

	/** 게시글 등록 */
	int insertBoard(Board board);

	/** 게시글 수정 */
	int updateBoard(Board board);

	/** 게시글 삭제 */
	int deleteBoard(Map<String, Object> map);

	/** 게시글 하나 조회 */
	Board selectBoardById(@Param("boardId") int boardId);

	/** 게시글 목록 조회 */
	List<Board> selectAllBoards();
			
	/** 게시글 검색 */
	List<Board> searchBoards(Map<String, Object> map);
			
	/** 핀 상태 변경 (관리자용) */
	int updatePinnedStatus(Map<String, Object> map);

	/** 조회수 증가 */
	int increaseViews(@Param("boardId") int boardId);

	/** 게시글 수 카운트 (페이징용) */
	int countBoards(Map<String, Object> map);


}
