package com.midas.inbrain.testdpkr.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccessTokenResponseDto{
    private Integer code;
    private String message;
    private String dataset;

    @Builder
    public AccessTokenResponseDto(Integer code, String message, String dataset){
        this.code = code;
        this.message = message;
        this.dataset = dataset;
    }
}