package com.hp.cc.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.hp.cc.common.Result;

/**
 * 未认证 处理
 * @author wangchen
 *
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable{

	private static final long serialVersionUID = 1L;

	//如果访问rest api ,没有提供任何认证资格，就返回401
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException)
			throws IOException, ServletException {
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(JSON.toJSONString(Result.createByErrorCodeMessage(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorizedddd")));
	}

}
