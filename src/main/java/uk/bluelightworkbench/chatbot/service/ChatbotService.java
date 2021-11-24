package uk.bluelightworkbench.chatbot.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.bluelightworkbench.chatbot.model.Holiday;

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
	
	public List<Holiday> findHolidays() throws IOException {
		
		List<Holiday> holidayList = new ArrayList<Holiday>();
		HashMap holidayLookup = new HashMap();
		
		Reader holidayData = new FileReader("src/main/resources/data.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(holidayData);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		for (CSVRecord record : records) {
			record.putIn(holidayLookup);
			
			Holiday mappedHoliday = objectMapper.convertValue(holidayLookup, Holiday.class);
			
			holidayList.add(mappedHoliday);
		};
		
		System.out.println(holidayLookup);
		
		//Map holidays to list, filter holiday list based on json sent to us.
		
		return holidayList;
	}
	
}
