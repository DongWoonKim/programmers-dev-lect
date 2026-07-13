package com.example.spring.basicboard.domain.repository;

import com.example.spring.basicboard.domain.entity.QBoard;
import com.example.spring.basicboard.domain.entity.QComment;
import com.example.spring.basicboard.domain.entity.QMember;
import com.example.spring.basicboard.dto.BoardListItemResponseDto;
import com.example.spring.basicboard.dto.BoardSearchRequestDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private static final QBoard board = QBoard.board;
    private static final QComment comment = QComment.comment;
    private static final QMember member = QMember.member;

    @Override
    public Page<BoardListItemResponseDto> searchBoards(BoardSearchRequestDto dto, Pageable pageable) {
        queryFactory.select()
                .from(board)
                .leftJoin(member).on(board.userId.eq(member.userId))
                .where(
                        titleContains(dto.getTitle())
                )
                .orderBy(board.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        return null;
    }

    // 제목 부분 일치 (Like %title%). 빈 값이면 조건 없음(null)
    private BooleanExpression titleContains(String title) {
        return (title == null || title.isBlank()) ? null : board.title.contains(title);
    }

    // 작성자 아이디 정확히 일치. 빈 값이면 조건 없음(null)
    private BooleanExpression userIdEquals(String userId) {
        return (userId == null || userId.isBlank()) ? null : board.userId.eq(userId);
    }

}
