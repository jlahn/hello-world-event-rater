package de.masch.webstarter.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rating {
	private String event;
	private String action;
	private RatingOption rating;
	
	public Rating(String event, String action, RatingOption rating){
		super();
		this.event = event;
		this.action = action;
		this.rating = rating;
	}
	
	public enum RatingOption {
		GOOD,
		BAD,
		NEITHER;
	}
	
	public static List<Rating> readFromCSV(String csvFileURL){
        List<Rating> ratings = new ArrayList<Rating>();
		try {
			Scanner scanner = new Scanner(new File(csvFileURL));
			while (scanner.hasNext()) {
				String currentLine = scanner.nextLine();
		        String[] currentLineEnties = currentLine.split(","); 
		        
		        String event = currentLineEnties[0];
		        String action = currentLineEnties[1];
		        RatingOption ratingOption = RatingOption.valueOf(currentLineEnties[2]);
		        
		        Rating rating = new Rating(event, action, ratingOption);
		        ratings.add(rating);
		        }
		        scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file "+ csvFileURL + "could not be found.");
			e.printStackTrace();
		}
		
		return ratings;
       
	}

	public String getEvent() {
		return event;
	}

	public String getAction() {
		return action;
	}

	public RatingOption getRatingOption() {
		return rating;
	}
}
