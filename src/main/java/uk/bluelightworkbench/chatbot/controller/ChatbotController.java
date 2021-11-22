package uk.bluelightworkbench.chatbot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uk.bluelightworkbench.chatbot.service.ChatbotService;

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
	
	@GetMapping("/")
	public String index() {
		return "Chatbot is up and running!";
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@GetMapping("/parse")
	public void getHolidays() throws IOException {
		chatbotService.parseCsv();
	}
	
	

}
