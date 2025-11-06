package com.seok.service;

import java.util.List;
import java.util.Map;
import com.seok.dto.Board;

/**
 * 게시판 비즈니스 로직(Service Layer)
 * 
 * Controller에서 받은 요청 데이터를 처리하고,
 * Mapper를 통해 DB 접근을 위임하는 역할을 수행한다.
 */
public interface BoardService {

    /** 
     * 게시글 등록 
     * @param board 등록할 게시글 객체
     * @return 처리된 행 수 (1 = 성공)
     */
    int insertBoard(Board board);

    /** 
     * 게시글 수정 
     * @param board 수정할 게시글 객체
     * @return 처리된 행 수
     */
    int updateBoard(Board board);

    /** 
     * 게시글 삭제 
     * @param boardId 게시글 ID 및 사용자 정보 등 삭제 조건
     * @return 처리된 행 수
     */
    int deleteBoard(int boardId);

    /** 
     * 게시글 하나 조회 
     * @param boardId 게시글 번호
     * @return 게시글 객체
     */
    Board selectBoardById(int boardId);

    /** 
     * 게시글 전체 조회 
     * @return 모든 게시글 목록
     */
    List<Board> selectAllBoards();
            
    /** 
     * 게시글 검색 
     * @param map 검색 조건 (키워드, 작성자, 날짜 등)
     * @return 검색 결과 목록
     */
    List<Board> searchBoards(Map<String, Object> map);
            
    /** 
     * 게시글 핀 상태 변경 (관리자용) 
     * @param map 게시글 ID 및 상태값
     * @return 처리된 행 수
     */
    int updatePinnedStatus(Map<String, Object> map);

    /** 
     * 게시글 조회수 증가 
     * @param boardId 게시글 번호
     * @return 처리된 행 수
     */
    int increaseViews(int boardId);

    /** 
     * 게시글 수 카운트 (페이징용) 
     * @param map 검색 조건
     * @return 게시글 총 개수
     */
    int countBoards(Map<String, Object> map);
}
