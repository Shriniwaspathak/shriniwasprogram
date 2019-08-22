package com.bridgelab.stock.model;

public class StockModel {
	public String stockChange;
	public String stockName;
	public int shareNumber;
	public double sharePrice;
	public String date;
	public String time;

	public String getStockChange() {
		return stockChange;
	}

	public void setStockChange(String stockChange) {
		this.stockChange = stockChange;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getShareNumber() {
		return shareNumber;
	}

	public void setShareNumber(int shareNumber) {
		this.shareNumber = shareNumber;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StockModel [stockChange=" + stockChange + ", stockName=" + stockName + ", shareNumber=" + shareNumber
				+ ", sharePrice=" + sharePrice + ", date=" + date + ", time=" + time + "]";
	}

}
