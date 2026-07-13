package com.example.spring.basicboard.domain.repository;

import com.example.spring.basicboard.domain.entity.QBoard;
import com.example.spring.basicboard.dto.BoardListItemResponseDto;
import com.example.spring.basicboard.dto.BoardSearchRequestDto;
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


    @Override
    public Page<BoardListItemResponseDto> searchBoards(BoardSearchRequestDto dto, Pageable pageable) {

        return null;
    }
}
