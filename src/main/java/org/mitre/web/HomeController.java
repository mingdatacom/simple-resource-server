package org.mitre.web;

import java.security.Principal;
import java.util.Locale;

import org.mitre.oauth2.introspectingfilter.IntrospectingTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@RequestMapping(value = "/email", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String user(Principal p) {
		return "email";
	}

	@RequestMapping(value = "/patient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String admin(Model model, Principal p) {
		return "patient";
	}

}
