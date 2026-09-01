package com.example.spring.boardservice.service;

import com.example.spring.boardservice.domain.repository.BoardRepository;
import com.example.spring.boardservice.dto.BoardListItemResponseDto;
import com.example.spring.boardservice.dto.BoardSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<BoardListItemResponseDto> searchBoards(BoardSearchRequestDto dto, Pageable pageable) {

        // searchBoards 게시글들 가져오기
        Page<BoardListItemResponseDto> page = boardRepository.searchBoards(dto, pageable);

        // boardRepository에서 가져온 ID추려서 auth-service로 요청해서 userName들 받아오기


        return null;
    }


}
