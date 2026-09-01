package com.example.spring.boardservice.service;

import com.example.spring.boardservice.client.AuthClient;
import com.example.spring.boardservice.domain.repository.BoardRepository;
import com.example.spring.boardservice.dto.BoardListItemResponseDto;
import com.example.spring.boardservice.dto.BoardSearchRequestDto;
import com.example.spring.boardservice.dto.UserNameResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final AuthClient authClient;

    public Page<BoardListItemResponseDto> searchBoards(BoardSearchRequestDto dto, Pageable pageable) {

        // searchBoards 게시글들 가져오기
        Page<BoardListItemResponseDto> page = boardRepository.searchBoards(dto, pageable);

        // boardRepository에서 가져온 ID추려서 auth-service로 요청해서 userName들 받아오기


        return null;
    }

    private List<UserNameResponseDto> fetchNames(List<String> userIds) {

        if ( userIds == null || userIds.isEmpty() ) {
            return List.of();
        }

        try {
            return authClient.getUserNames(userIds);
        } catch (Exception e) {
            log.warn("[작성자 이름 조회 실패] auth-service 호출 불가 — userId로 대체 표시. {}", e.getMessage());
            return List.of();
        }

    }


}
