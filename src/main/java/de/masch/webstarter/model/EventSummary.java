package de.masch.webstarter.model;

import de.masch.webstarter.model.Rating.RatingOption;

public class EventSummary {

	private String event;
	private int goodCount;
	private int badCount;
	private int neitherCount;
	
	public EventSummary(String event, int goodCount, int badCount, int neitherCount){
		super();
		this.event = event;
		this.goodCount = goodCount;
		this.badCount = badCount;
		this.neitherCount = neitherCount;
	}
	
	/**
	 * Increases the count for the ratingOption by one.
	 * @param ratingOption
	 * @return the new count for the ratingOption or -1 if the ratingOption was neither GOOD, BAD nor NEITHER.
	 */
	public int increaseRatingCount(RatingOption ratingOption){
		int count = -1;
		if(RatingOption.GOOD.equals(ratingOption)){
			this.goodCount++;
			count = this.goodCount;
		}
		else if(RatingOption.BAD.equals(ratingOption)){
			this.badCount++;
			count = this.badCount;
		}
		else if(RatingOption.NEITHER.equals(ratingOption)){
			this.neitherCount++;
			count = this.neitherCount;
		}
		return count;
	}
	
	/**
	 * @return the new value of goodCount.
	 */
	public int increaseGoodCount(){
		this.goodCount ++;
		return goodCount;
	}
	/**
	 * @return the new value of badCount.
	 */
	public int increaseBadCount(){
		this.badCount ++;
		return badCount;
	}
	/**
	 * @return the new value of neitherCount.
	 */
	public int increaseNeitherCount(){
		this.neitherCount ++;
		return neitherCount;
	}

	public String getEvent() {
		return event;
	}

	public int getGoodCount() {
		return goodCount;
	}

	public int getBadCount() {
		return badCount;
	}

	public int getNeitherCount() {
		return neitherCount;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
