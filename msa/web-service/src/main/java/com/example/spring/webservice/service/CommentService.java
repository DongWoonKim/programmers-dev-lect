package com.example.spring.webservice.service;

import com.example.spring.webservice.client.BoardClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private BoardClient boardClient;

}
