package com.midas.inbrain.testdpkr.domains;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AccessTokenDatasetJSONObj{
    private String appId;
    private String accessToken;

    @Builder
    public AccessTokenDatasetJSONObj( String appId, String accessToken ){
        this.appId = appId;
        this.accessToken = accessToken;
    }

    @Override
    public String toString(){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }
}