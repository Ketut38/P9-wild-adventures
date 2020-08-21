package com.wildadventures.msusers.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.IDToken;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.UserInfo;

import com.wildadventures.msusers.model.User;

@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired HttpServletRequest request;

	@GetMapping(value = "/userInfos", produces = MediaType.APPLICATION_JSON_VALUE)
	public User handleUserInfoRequest(Principal principal) {
		System.out.println("principal "+principal);

		User user = new User();

		if (principal instanceof KeycloakPrincipal) {

			KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
			AccessToken token = kp.getKeycloakSecurityContext().getToken();
			user.setId(token.getId());
			user.setEmail(token.getEmail());
			user.setUserName(token.getName());
			user.setPhoneNumber(token.getPhoneNumber());
			user.setGender(token.getGender());
			user.setFirstName(token.getFamilyName());
			/*Map<String, Object> otherClaims = token.getOtherClaims();
			user.setCustomAttributes(otherClaims);*/ // Pour créer des attributs custom. (set otherclaims se fait dans keycloak user attributes=
		}
		
		return user;
		
		
	}

	@GetMapping(value = "/public", produces = MediaType.APPLICATION_JSON_VALUE)
	public void logout() throws ServletException{
		request.logout();
	}
}
