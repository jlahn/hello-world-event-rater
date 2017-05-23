package de.masch.webstarter.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.masch.webstarter.model.ActionSummary;
import de.masch.webstarter.model.Rating;
import de.masch.webstarter.model.Rating.RatingOption;

@Controller
@RequestMapping("actions/summary")
public class ActionsSummaryController {
	@RequestMapping(method = RequestMethod.GET)
	public String getPage(Model model){
		String csvFileURL = "C:/Users/Julia Lahn/workspaceDashboard/hello-world-event-rater/src/main/resources/ratings.csv";
		List<Rating> ratings = Rating.readFromCSV(csvFileURL);
		
		HashMap<String, ActionSummary> actionSummaries = new HashMap<String,ActionSummary>();
		for (Rating rating : ratings) {
			String action = rating.getAction();
			RatingOption ratingOption = rating.getRatingOption();
			
			ActionSummary actionSummary;
			if (actionSummaries.containsKey(action)){
				actionSummary = actionSummaries.get(action);
			}
			else{
				actionSummary = new ActionSummary(action, 0, 0, 0);
				actionSummaries.put(action, actionSummary);
			}
			
			actionSummary.increaseRatingCount(ratingOption);
		}
		model.addAttribute("actionSummaries",actionSummaries.values());
		
		return "actions-summary";
	}

}
