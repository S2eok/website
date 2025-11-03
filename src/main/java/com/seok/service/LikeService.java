package com.seok.service;

import com.seok.dto.Like;

public interface LikeService {
	
		/** 좋아요 추가 */
		int insertLike(Like like);
		
		/** 좋아요 취소 */
		int deleteLike(Like like);
	
		/** 좋아요 여부 확인 */
		boolean checkUserLike(Like like);
	    
		/** 게시판 좋아요 반영 */
		int updateBoardLikeCount(int boardId);
		
		/** 댓글 좋아요 반영 */
		int updateCommentLikeCount(int commentId);
		
}
