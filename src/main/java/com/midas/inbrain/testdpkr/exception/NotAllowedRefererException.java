package com.midas.inbrain.testdpkr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotAllowedRefererException extends RuntimeException{
	private static final long serialVersionUID = -2312224814075407573L;

    public NotAllowedRefererException(String string) {
	}
}