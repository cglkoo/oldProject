package com.kaokaoba.msg;

public class Msg {
	 int mId;
	 String mName;
	 String mDate;
	 int mStatus;
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
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public int getmStatus() {
		return mStatus;
	}
	public void setmStatus(int mStatus) {
		this.mStatus = mStatus;
	}
	public Msg(int mId, String mName, String mDate, int mStatus) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mDate = mDate;
		this.mStatus = mStatus;
	}
	public Msg() {
		super();
	}
	@Override
	public String toString() {
		return "Msg [mId=" + mId + ", mName=" + mName + ", mDate=" + mDate
				+ ", mStatus=" + mStatus + "]";
	}
	 
	 

}
