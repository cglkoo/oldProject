package com.store.elscore;

public class ElScores {
	int elscoreId;
    int userId;
    String userName;
    String mTypes;
    int mPrices;
    int mNum;
	public ElScores() {
		
	}
	public ElScores(int elscoreId, int userId, String userName, String mTypes, int mPrices, int mNum) {
		super();
		this.elscoreId = elscoreId;
		this.userId = userId;
		this.userName = userName;
		this.mTypes = mTypes;
		this.mPrices = mPrices;
		this.mNum = mNum;
	}
	public int getElscoreId() {
		return elscoreId;
	}
	public void setElscoreId(int elscoreId) {
		this.elscoreId = elscoreId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	@Override
	public String toString() {
		return "ElScores [elscoreId=" + elscoreId + ", userId=" + userId + ", userName=" + userName + ", mTypes="
				+ mTypes + ", mPrices=" + mPrices + ", mNum=" + mNum + "]";
	}
	
	
}
