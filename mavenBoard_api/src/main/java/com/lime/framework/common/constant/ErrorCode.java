package com.lime.framework.common.constant;

import lombok.Getter;

@Getter
public enum ErrorCode {

    //400 BAD_REQUEST 잘못된 요청
    INVALID_PARAMETER(400, "Incorrect input value."),
    UNAUTHORIZED(401, "Unauthorized. please login."),
    //404 NOT_FOUND 잘못된 리소스 접근
    BAD_REQUEST(403, "The page requires permission."),
    DISPLAY_NOT_FOUND(404, "The page cannot be found. "),
    FTP_ERROR(500, "FTP ERROR."),
    //500 INTERNAL SERVER ERROR
    PAYMENT_ERROR(500, "Payment has already been done."),
    INTERNAL_SERVER_ERROR(500, "Server encountered an error. Please contact the server manager."),
    DAILY_SATTLE_ERROR(500, "Daily report has already been made."),
    MONTHLY_SATTLE_ERROR(500, "Monthly report has already been made."),

    NOT_FOUND_SATTLE(500,"Can not find report.");



    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
