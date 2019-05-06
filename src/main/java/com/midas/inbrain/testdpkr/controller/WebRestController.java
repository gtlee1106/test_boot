package com.midas.inbrain.testdpkr.controller;

import javax.servlet.http.HttpServletRequest;

import com.midas.inbrain.testdpkr.dto.AccessTokenResponseDto;
import com.midas.inbrain.testdpkr.services.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

    private AccessTokenService accessTokenService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/certificate")
    public @ResponseBody AccessTokenResponseDto certificate(
        HttpServletRequest request, 
        @RequestParam(required = true) String accessToken ){
            return accessTokenService.certificateToken(request, accessToken);
    }
}
