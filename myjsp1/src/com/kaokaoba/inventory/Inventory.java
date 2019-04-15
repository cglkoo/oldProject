package com.kaokaoba.inventory;

public class Inventory {
	 int mId;
	 String mName;
	 int mPrice;
	 int mSum;
	public Inventory(int mId, String mName, int mPrice, int mSum) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mPrice = mPrice;
		this.mSum = mSum;
	}
	public Inventory() {
		super();
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
	public int getmSum() {
		return mSum;
	}
	public void setmSum(int mSum) {
		this.mSum = mSum;
	}
	@Override
	public String toString() {
		return "Inventory [mId=" + mId + ", mName=" + mName + ", mPrice="
				+ mPrice + ", mSum=" + mSum + "]";
	}

}
