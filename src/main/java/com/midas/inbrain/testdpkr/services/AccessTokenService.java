package com.midas.inbrain.testdpkr.services;

import java.net.URI;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import com.midas.inbrain.testdpkr.domains.AccessToken;
import com.midas.inbrain.testdpkr.domains.AccessTokenDatasetJSONObj;
import com.midas.inbrain.testdpkr.domains.AccessTokenRepository;
import com.midas.inbrain.testdpkr.domains.AllowedReferer;
import com.midas.inbrain.testdpkr.domains.AllowedRefererRepository;
import com.midas.inbrain.testdpkr.dto.AccessTokenResponseDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccessTokenService{
    private AccessTokenRepository accessTokenRepository;
    private AllowedRefererRepository allowedRefererRepository;

    @Transactional
    public AccessTokenResponseDto certificateToken(HttpServletRequest request, String token){
        String refererBaseUrl = getBaseUrl(request.getHeader("referer"));

        AllowedReferer referer = allowedRefererRepository.findByUrl(refererBaseUrl);
        if( referer == null ){
            AccessTokenResponseDto dto = AccessTokenResponseDto.builder()
            .code(900)
            .message("실패")
            .dataset("")
            .build();

            return dto;
        }
        
        AccessToken accessToken = AccessToken.builder()
            .accessToken(token)
            .build();

        AccessTokenDatasetJSONObj obj = AccessTokenDatasetJSONObj.builder()
            .accessToken(token)
            .appId("DDD")
            .build();

        AccessTokenResponseDto dto = AccessTokenResponseDto.builder()
            .code(100)
            .message("성공")
            .dataset(obj.toString())
            .build();
        
        accessTokenRepository.save(accessToken);

        return dto;        
    }

    // AccessControllService에 같은 함수 있음. 별도로 빼든가 해야... 
    private String getBaseUrl(String strUrl){
        if(strUrl == null)
            return null;
        
        try {
            URL url = URI.create(strUrl).toURL();
            return url.getAuthority();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}