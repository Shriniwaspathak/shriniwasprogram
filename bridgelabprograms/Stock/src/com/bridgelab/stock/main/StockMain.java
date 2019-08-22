package com.bridgelab.stock.main;

import com.bridgelab.stock.service.StockImplementation;
import com.bridgelab.stock.service.StockInterface;
import com.bridgelab.stock.utility.Util;

public class StockMain {
	public static void main(String[] args) {
		StockInterface stock = new StockImplementation();

		System.out.println("Enter 1 for buy");
		System.out.println("Enter 2 for sale");
		int choose = Util.inputInteger();
		switch (choose) {
		case 1:
			stock.buy();
			break;
		case 2:
			stock.sale();

		}

	}

}
