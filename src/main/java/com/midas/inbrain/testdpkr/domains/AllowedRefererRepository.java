package com.midas.inbrain.testdpkr.domains;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AllowedRefererRepository extends JpaRepository<AllowedReferer, Long>{
    public AllowedReferer findByUrl(String url);
}   