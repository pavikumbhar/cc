package com.hp.cc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.cc.common.Result;
import com.hp.cc.jwt.JwtAuthenticationRequest;
import com.hp.cc.jwt.JwtAuthenticationResponse;
import com.hp.cc.jwt.JwtTokenUtil;
import com.hp.cc.jwt.JwtUser;
import com.hp.cc.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthService authService;
	

	@PostMapping("/token")
	public Result token(
			@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest) {

		// 交给springsecurity管理，会去验证用户名和密码是否正确。
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(
						jwtAuthenticationRequest.getUsername(),
						jwtAuthenticationRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return Result.createBySuccess(authService.token(jwtAuthenticationRequest));
	}
}