package uk.bluelightworkbench.chatbot.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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

@RestController

public class ChatbotController {
	
	@Autowired
	ChatbotService chatbotService;
	
	@GetMapping(path = { "/chatbot" }, produces = APPLICATION_JSON_VALUE)
	public String index() {
		return "Chatbot is up and running!";
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@GetMapping("/chatbot/findHolidays")
	public List<Holiday> getHolidays() throws IOException {
		return chatbotService.findHolidays();
	}
	
	

}
