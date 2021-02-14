package com.deepak.pma.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.DispatcherServlet;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
	
	@GetMapping("/error")
	public String errorHandler(HttpServletRequest request) {
			Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
			
			Integer statusCode = null;
			if(status != null) {
				 statusCode = Integer.valueOf((status.toString()));
				 if(statusCode==HttpStatus.NOT_FOUND.value()) {
						return "errorpage/error-404";
					}else if (statusCode==HttpStatus.FORBIDDEN.value()) {
						return "errorpage/error-403";
					}
			}
			
			
			
			return "errorpage/error";
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

}
