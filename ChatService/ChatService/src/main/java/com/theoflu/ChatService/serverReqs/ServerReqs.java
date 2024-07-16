package com.theoflu.ChatService.serverReqs;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url ="http://localhost:8080/api/user", name = "ServerRequests")
//@FeignClient(url = "${BACKEND_URL}", name = "ServerRequests")
public interface ServerReqs {

    @GetMapping("/username")
     ResponseEntity<String> returnUsername(@RequestHeader(value = "Authorization", required = false) String token);
}