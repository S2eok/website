package com.seok.mapper;


import org.apache.ibatis.annotations.Param;

import com.seok.dto.Like;

public interface LikeMapper {

	/** 좋아요 추가 */
	int insertLike(Like like);
	
	/** 좋아요 취소 */
	int deleteLike(Like like);

	/** 좋아요 여부 확인 */
	int checkUserLike(Like like);
    
	/** 게시판 좋아요 반영 */
	int updateBoardLikeCount(@Param("boardId") int boardId);
	
	/** 댓글 좋아요 반영 */
	int updateCommentLikeCount(@Param("commentId") int commentId);

}
