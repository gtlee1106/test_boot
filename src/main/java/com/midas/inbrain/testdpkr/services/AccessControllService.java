package com.midas.inbrain.testdpkr.services;

import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.midas.inbrain.testdpkr.domains.AccessToken;
import com.midas.inbrain.testdpkr.domains.AccessTokenRepository;
import com.midas.inbrain.testdpkr.domains.AllowedReferer;
import com.midas.inbrain.testdpkr.domains.AllowedRefererRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccessControllService{
    private AccessTokenRepository accessTokenRepository;
    private AllowedRefererRepository allowedRefererRepository;

    @Transactional
    public boolean checkAllowedAccess(HttpServletRequest request){
        String refererBaseUrl = getBaseUrl(request.getHeader("referer"));
        String accessToken = request.getHeader("accessToken");

        List<AccessToken> list_tokenObj = accessTokenRepository.findByAccessToken("sdfhjsfhjskdhkj");
        if( list_tokenObj.size() == 0 )
            return false;

        AllowedReferer refererObj = allowedRefererRepository.findByUrl(refererBaseUrl);
        if( refererObj == null )
            return false;
        
        return false;
    }

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