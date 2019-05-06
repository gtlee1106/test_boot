package com.midas.inbrain.testdpkr.controller;

import javax.servlet.http.HttpServletRequest;

import com.midas.inbrain.testdpkr.services.AccessControllService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebController {
    // 접근 여부 체크를... controller에서? 아니면 service가?
    private AccessControllService accessControllService;

    @GetMapping("/helloView")
    public String hello(HttpServletRequest request) {
        if(accessControllService.checkAllowedAccess(request))
            return "hello";
        return "error";
    }

    @GetMapping("/upload")
    public String upload(HttpServletRequest request) {
        if(accessControllService.checkAllowedAccess(request))
            return "upload";
        return "error";
    }

    @GetMapping("/download")
    public String download(HttpServletRequest request) {
        if(accessControllService.checkAllowedAccess(request))
            return "download";
        return "error";
    }

    @GetMapping("/viewer")
    public String viewer(HttpServletRequest request) {
        if(accessControllService.checkAllowedAccess(request))
            return "viewer";
        return "error";
    }
}
