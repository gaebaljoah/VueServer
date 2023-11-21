package com.lime.framework.common.handler;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String error(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (null != status) {
            int statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.FORBIDDEN.value()){
                return "view/error/N_calculate_403";
            }
            if(statusCode == HttpStatus.NOT_FOUND.value()){
                return "view/error/N_calculate_404";
            }
        }
        return "view/error/N_calculate_500";
    }

    @RequestMapping("/error/403")
    public String error403(HttpServletRequest request){
        return "view/error/N_calculate_403";
    }
}
