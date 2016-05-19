/*******************************************************************************
 * Copyright 2014 The MITRE Corporation
 *   and the MIT Kerberos and Internet Trust Consortium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.mitre.web;

import java.security.Principal;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Resource;

import org.mitre.oauth2.introspectingfilter.IntrospectingTokenService;
import org.mitre.openid.connect.client.OIDCAuthenticationFilter;
import org.mitre.openid.connect.client.SubjectIssuerGrantedAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	IntrospectingTokenService tokenService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String home(Locale locale, Model model, Principal p) {

		// Check access token
		
		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String user(Principal p) {
		return "user";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin(Model model, Principal p) {
		return "admin";
	}

}
