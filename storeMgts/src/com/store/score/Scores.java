package com.store.score;

public class Scores {
	int scoreId;
	String mTypes;
	int mPrices;
	int mNumbers;
	int mValues;

	public Scores() {
		
	}

	public Scores(int scoreId, String mTypes, int mPrices, int mNumbers, int mValues) {
		super();
		this.scoreId = scoreId;
		this.mTypes = mTypes;
		this.mPrices = mPrices;
		this.mNumbers = mNumbers;
		this.mValues = mValues;
	}

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}

	public String getmTypes() {
		return mTypes;
	}

	public void setmTypes(String mTypes) {
		this.mTypes = mTypes;
	}

	public int getmPrices() {
		return mPrices;
	}

	public void setmPrices(int mPrices) {
		this.mPrices = mPrices;
	}

	public int getmNumbers() {
		return mNumbers;
	}

	public void setmNumbers(int mNumbers) {
		this.mNumbers = mNumbers;
	}

	public int getmValues() {
		return mValues;
	}

	public void setmValues(int mValues) {
		this.mValues = mValues;
	}

	@Override
	public String toString() {
		return "Scores [scoreId=" + scoreId + ", mTypes=" + mTypes + ", mPrices=" + mPrices + ", mNumbers=" + mNumbers
				+ ", mValues=" + mValues + "]";
	}
	

}
