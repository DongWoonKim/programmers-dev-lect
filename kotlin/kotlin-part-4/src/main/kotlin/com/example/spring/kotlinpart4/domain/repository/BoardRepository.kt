package com.example.spring.kotlinpart4.domain.repository

import com.example.spring.kotlinpart4.domain.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long> {
}