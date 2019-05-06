package com.midas.inbrain.testdpkr.domains;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTokenRepository extends JpaRepository<AccessToken, Long>{
    public List<AccessToken> findByAccessToken(String accessToken);
}