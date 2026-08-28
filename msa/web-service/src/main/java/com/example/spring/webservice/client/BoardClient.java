package com.example.spring.webservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "board-service", url = "${edge-service.url:http://localhost:8000}")
public interface BoardClient {
}
