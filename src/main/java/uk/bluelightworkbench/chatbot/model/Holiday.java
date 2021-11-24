package uk.bluelightworkbench.chatbot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Holiday
 * 
 * Class to define a holiday's information
 * 
 * @author bmoore
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)

public class Holiday {
	
	private int holidayReference;
	
	private String hotelName;
	
	private String city;
	
	private String Continent;
	
	private String country;
	
	private String category;
	
	private int starRating;
	
	private String tempRating;
	
	private String location;
	
	private int pricePerNight;

}
