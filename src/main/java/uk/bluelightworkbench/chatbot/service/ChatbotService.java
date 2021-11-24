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
		Iterable<CSVRecord> records;
		
		try {
		
		Reader holidayData = new FileReader("src/main/resources/data.csv");
		records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(holidayData);
		
		} catch (IOException e) {
			throw e;
		};
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		for (CSVRecord record : records) {
			HashMap holidayLookup = new HashMap();
			
			record.putIn(holidayLookup);
			
			try {
			
			Holiday mappedHoliday = objectMapper.convertValue(holidayLookup, Holiday.class);
			
			holidayList.add(mappedHoliday);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		};
		
		return holidayList;
	}
	
}
