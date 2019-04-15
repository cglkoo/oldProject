package com.kaokaoba.stock;

public class Stock {
	int mId;
	String mType;
	int mPrice;
	int mNumber;
	int mValue;
	String mDate;
	@Override
	public String toString() {
		return "Sell [mId=" + mId + ", mType=" + mType + ", mPrice="
				+ mPrice + ", mNumber=" + mNumber + ", mValue=" + mValue
				+ ", mDate=" + mDate + "]";
	}
	public Stock() {
		super();
	}
	public Stock(int mId, String mType, int mPrice, int mNumber, int mValue,
			String mDate) {
		super();
		this.mId = mId;
		this.mType = mType;
		this.mPrice = mPrice;
		this.mNumber = mNumber;
		this.mValue = mValue;
		this.mDate = mDate;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
	public int getmNumber() {
		return mNumber;
	}
	public void setmNumber(int mNumber) {
		this.mNumber = mNumber;
	}
	public int getmValue() {
		return mValue;
	}
	public void setmValue(int mValue) {
		this.mValue = mValue;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
}
