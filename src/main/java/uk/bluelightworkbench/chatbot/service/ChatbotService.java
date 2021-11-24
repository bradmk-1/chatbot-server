package uk.bluelightworkbench.chatbot.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	public List<Holiday> findHolidays(String continent, Integer starRating, String tempRating) 
		throws IOException { 
		
		var holidayList = new ArrayList<Holiday>();
		Iterable<CSVRecord> records;
		
		try {
		
		Reader holidayData = new FileReader("src/main/resources/data.csv");
		records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(holidayData);
		
		} catch (IOException e) {
			throw e;
		};
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		for (CSVRecord record : records) {
			var holidayLookup = new HashMap();
			
			record.putIn(holidayLookup);
			
			try {
			
			var mappedHoliday = objectMapper.convertValue(holidayLookup, Holiday.class);
			
			holidayList.add(mappedHoliday);
			} catch (IllegalArgumentException e) {
				throw e;
			}
		}
		
		
		
//		if (continent != null && starRating != null && tempRating != null) {
//			
//			var streamedList = holidayList.stream()
//			.filter(holiday -> 
//			 holiday.getContinent() == continent && 
//			 holiday.getStarRating() == starRating && 
//			 holiday.getTempRating() == tempRating)
//			.collect(Collectors.toList());
//			
//			System.out.println(streamedList);
//		
//			holidayList = (ArrayList<Holiday>) streamedList;
//			
//		};
			
		
		return holidayList;
	}
	
}
