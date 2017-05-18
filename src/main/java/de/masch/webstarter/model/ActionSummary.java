package de.masch.webstarter.model;

import de.masch.webstarter.model.Rating.RatingOption;

public class ActionSummary {
	private String action;
	private int goodCount = 0;
	private int badCount = 0;
	private int neitherCount = 0;
	
	public ActionSummary(String action){
		this.action = action;
	}
	
	public ActionSummary(String action, int goodCount, int badCount, int neitherCount){
		super();
		this.action = action;
		this.goodCount = goodCount;
		this.badCount = badCount;
		this.neitherCount = neitherCount;
	}

	public int increaseRatingCount(RatingOption ratingOption){
		int count = -1;
		
		if(RatingOption.GOOD.equals(ratingOption)){
			this.goodCount++;
			count = this.goodCount;
		}
		else if (RatingOption.BAD.equals(ratingOption)) {
			this.badCount++;
			count = this.badCount;
		}
		else if (RatingOption.NEITHER.equals(ratingOption)) {
			this.neitherCount++;
			count = this.neitherCount;
		}
		
		return count;
	}
	
	public String getAction() {
		return this.action;
	}

	public int getGoodCount() {
		return this.goodCount;
	}
	
	public int getBadCount() {
		return this.badCount;
	}
	
	public int getNeitherCount() {
		return this.neitherCount;
	}
}
