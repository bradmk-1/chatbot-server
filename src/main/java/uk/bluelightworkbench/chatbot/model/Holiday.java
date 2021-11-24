package uk.bluelightworkbench.chatbot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

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

public class Holiday {
	
	@JsonProperty("HolidayReference")
	private int holidayReference;
	
	@JsonProperty("HotelName")
	private String hotelName;
	
	@JsonProperty("City")
	private String city;
	
	@JsonProperty("Continent")
	private String continent;
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("Category")
	private String category;
	
	@JsonProperty("StarRating")
	private int starRating;
	
	@JsonProperty("TempRating")
	private String tempRating;
	
	@JsonProperty("Location")
	private String location;
	
	@JsonProperty("PricePerPerNight")
	private int pricePerNight;

}
