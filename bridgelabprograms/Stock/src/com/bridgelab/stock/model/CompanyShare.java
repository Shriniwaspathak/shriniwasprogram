package com.bridgelab.stock.model;

public class CompanyShare {
	public String stockName;
	public int shareName;
	public int sharePrice;
	public int shareNumber;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getShareName() {
		return shareName;
	}

	public void setShareName(int shareName) {
		this.shareName = shareName;
	}

	public int getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;
	}

	public int getShareNumber() {
		return shareNumber;
	}

	public void setShareNumber(int shareNumber) {
		this.shareNumber = shareNumber;
	}

	@Override
	public String toString() {
		return "CompanyShare [stockName=" + stockName + ", shareName=" + shareName + ", sharePrice=" + sharePrice
				+ ", shareNumber=" + shareNumber + "]";
	}

}
