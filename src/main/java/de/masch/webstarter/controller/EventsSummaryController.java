package de.masch.webstarter.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.masch.webstarter.model.EventSummary;
import de.masch.webstarter.model.Rating;
import de.masch.webstarter.model.Rating.RatingOption;

@Controller
@RequestMapping("events/summary")
public class EventsSummaryController {

	@RequestMapping(method = RequestMethod.GET)
	public String getPage(Model model){
		String csvFileURL = "C:/Users/Julia Lahn/workspaceDashboard/hello-world-event-rater/src/main/resources/ratings.csv";
		List<Rating> ratings = Rating.readFromCSV(csvFileURL);
		
		HashMap<String, EventSummary> eventSummaries = new HashMap<String,EventSummary>();
		for (Rating rating : ratings) {
			String event = rating.getEvent();
			RatingOption ratingOption = rating.getRatingOption();
			
			EventSummary eventSummary;
			if (eventSummaries.containsKey(event)){
				eventSummary = eventSummaries.get(event);
			}
			else{
				eventSummary = new EventSummary(event, 0, 0, 0);
				eventSummaries.put(event, eventSummary);
			}
			
			eventSummary.increaseRatingCount(ratingOption);
		}
		model.addAttribute("eventSummaries",eventSummaries.values());
		
		return "events-summary";
	}
}
