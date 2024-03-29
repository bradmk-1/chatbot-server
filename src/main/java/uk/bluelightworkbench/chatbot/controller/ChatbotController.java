package uk.bluelightworkbench.chatbot.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uk.bluelightworkbench.chatbot.service.ChatbotService;
import uk.bluelightworkbench.chatbot.model.*;

/**
 * ChatbotController
 * 
 * Spring Controller Class for Chatbot.
 * 
 * @author bmoore
 *
 */

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController

public class ChatbotController {
	
	@Autowired
	ChatbotService chatbotService;
	
	@GetMapping(path = { "/chatbot" }, produces = APPLICATION_JSON_VALUE)
	public String index() {
		return "Chatbot is up and running!";
	}
	
	@GetMapping(path = { "/chatbot/findHolidays/{continent}/{starRating}/{tempRating}" }, produces = APPLICATION_JSON_VALUE)
	public List<Holiday> getHolidays(
			@PathVariable String continent, 
			@PathVariable Integer starRating,
			@PathVariable String tempRating) throws IOException {
		return chatbotService.findHolidays(continent, starRating, tempRating);
	}
	
	

}
