package com.lime.framework.common.handler;

import com.lime.framework.common.constant.CustomException;
import com.lime.framework.common.constant.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ CustomException.class })
    protected ResponseEntity handleCustomException(CustomException ex) {
        Map map = new HashMap<String,Object>();
        map.put("errorCode", ex.getErrorCode());
        map.put("message", ex.getErrorCode().getMessage());
        return new ResponseEntity(map, null, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler({ Exception.class })
    protected ResponseEntity handleServerException(Exception ex) {
        Map map = new HashMap<String,Object>();
        map.put("errorCode", ErrorCode.INTERNAL_SERVER_ERROR);
        map.put("message", ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        return new ResponseEntity(map, null, HttpStatus.valueOf(ErrorCode.INTERNAL_SERVER_ERROR.getStatus()));
    }
//    @ExceptionHandler({ AuthenticationException.class })
//    protected ResponseEntity handleServerException(AuthenticationException ex) {
//        Map map = new HashMap<String,Object>();
//        map.put("errorCode", ErrorCode.INTERNAL_SERVER_ERROR);
//        map.put("message", ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
//        return new ResponseEntity(map, null, HttpStatus.valueOf(ErrorCode.INTERNAL_SERVER_ERROR.getStatus()));
//    }

    @ExceptionHandler({ HttpClientErrorException.BadRequest.class })
    protected ResponseEntity handleBadRequestException(Exception ex) {
        Map map = new HashMap<String,Object>();
        map.put("errorCode", ErrorCode.BAD_REQUEST);
        map.put("message", ErrorCode.BAD_REQUEST.getMessage());
        return new ResponseEntity(map, null, HttpStatus.valueOf(ErrorCode.BAD_REQUEST.getStatus()));
    }
}
