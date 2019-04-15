package com.store.sell;

public class Sell {
	int mId;
	String mTypes;
	int mPrices;
	int mNumbers;
	int mValues;
	String mDate;
	@Override
	public String toString() {
		return "Sell [mId=" + mId + ", mTypes=" + mTypes + ", mPrices="
				+ mPrices + ", mNumbers=" + mNumbers + ", mValues=" + mValues
				+ ", mDate=" + mDate + "]";
	}
	public Sell() {
		super();
	}
	public Sell(int mId, String mTypes, int mPrices, int mNumbers, int mValues,
			String mDate) {
		super();
		this.mId = mId;
		this.mTypes = mTypes;
		this.mPrices = mPrices;
		this.mNumbers = mNumbers;
		this.mValues = mValues;
		this.mDate = mDate;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
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
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
}
