package uk.bluelightworkbench.chatbot.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

/**
 * ChatbotService
 * 
 * Spring service class for Chatbot.
 * 
 * @author bmoore
 *
 */


@Service
public class ChatbotService {
	
	public void parseCsv() throws IOException {
		
		Reader in = new FileReader("/resources/data.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		
		for (CSVRecord record : records) {
			System.out.println(record);
		};
		
	}
}
