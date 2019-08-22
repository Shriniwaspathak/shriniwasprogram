package com.bridgelab.stock.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelab.stock.model.CompanyShare;
import com.bridgelab.stock.model.StockModel;
import com.bridgelab.stock.utility.Util;
import com.google.gson.Gson;

public class StockImplementation implements StockInterface {
	JSONObject jsonobject = new JSONObject();
	JSONArray jsonarray = new JSONArray();
	ArrayList<StockModel> stockarray = new ArrayList<StockModel>();
	ArrayList<CompanyShare> companyarray = new ArrayList<CompanyShare>();
	JSONParser parser = new JSONParser();

	@Override
	public void buy() {
		jsonReadCompany();
		System.out.println("Enter the name of the company for buy");
		String companyname = Util.inputString();
		System.out.println("Enter the share number for buy");
		int amount = Util.inputInteger();

		CompanyShare share = null;
		for (CompanyShare name : companyarray) {
			if (companyname.equals(name.getStockName()))
				
			share = name;
			break;
		}

		int shareamount = share.getShareNumber();
		StockModel model = new StockModel();
		if (shareamount > amount) {
			int totalamount = shareamount - amount;
			share.setShareName(amount);
			model.setShareNumber(share.getShareNumber());
			model.setSharePrice(share.getSharePrice());
			model.setStockChange("buy");
			model.setTime(LocalTime.now().toString());
			model.setDate(LocalTime.now().toString());
			stockarray.add(model);
			writeUser();
			save(totalamount, share);
			printReport();
		} else {
			System.out.println("share is not available");

		}
	}

	@Override
	public void sale() {
		jsonReadCompany();

		System.out.println("Enter the company name for sale share");
		String companyname = Util.inputString();
		System.out.println("Enter the amount to sale");
		int amount = Util.inputInteger();

		StockModel model = new StockModel();
		CompanyShare share = null;
		for (CompanyShare companyshare : companyarray) {
			if (companyname.equals(companyshare.getStockName())) {
				share = companyshare;
				break;
			}
		}
		int shareamount = share.getShareName();
		if (shareamount > share.getShareName()) {
			int totalamount = shareamount + amount;
			share.setShareName(amount);

			model.setShareNumber(share.getShareNumber());
			model.setSharePrice(share.getSharePrice());
			model.setStockChange("sale");
			model.setStockName(share.getStockName());
			model.setTime(LocalTime.now().toString());
			model.setDate(LocalDate.now().toString());
			stockarray.add(model);

			writeUser();
			save(totalamount, share);
			printReport();
		} else {
			System.out.println("decrese your share amount");
		}
	}

	@Override
	public void printReport() {
		writeCompany();

	}

	@Override
	public void jsonReadUser() {
		try {
			jsonarray = (JSONArray) parser.parse(new FileReader(
					"C:\\Users\\Shriniwas Pathak\\eclipse-workspace\\Stock\\src\\com\\bridgelab\\stock\\resources\\stock.json"));
			for (Object object : jsonarray) {
				jsonobject = (JSONObject) object;

				String stockchange = (String) jsonobject.get("stockchange");
				String stockname = (String) (jsonobject.get("stockname"));

				int sharenumber = (int) (jsonobject.get("sharenumber"));
				double shareprice = (double) (jsonobject.get("shareprice"));
				System.out.println("hello");
				String date = (String) (jsonobject.get("date"));
				String time = (String) (jsonobject.get("time"));
				StockModel stockmodel = new StockModel();
				stockarray.add(stockmodel);

			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void jsonReadCompany() {
		try {
			jsonarray = (JSONArray) parser.parse(new FileReader(
					"C:\\\\Users\\\\Shriniwas Pathak\\\\eclipse-workspace\\\\Stock\\\\src\\\\com\\\\bridgelab\\\\stock\\\\resources\\\\writejack.json"));
			for (Object object : jsonarray) {
				jsonobject = (JSONObject) object;

				String stockchange = (String) jsonobject.get("stockchange");
				String stockname = (String) (jsonobject.get("stockname"));

				int sharenumber = (int) (jsonobject.get("sharenumber"));
				double shareprice = (double) (jsonobject.get("shareprice"));
				System.out.println("hello");
				String date = (String) (jsonobject.get("date"));
				String time = (String) (jsonobject.get("time"));
				StockModel stockmodel = new StockModel();
				stockarray.add(stockmodel);

			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	@Override
	public void save(int totalvalue, CompanyShare companyshare) {
		companyshare.setShareNumber(totalvalue);

	}

	@Override
	public void writeUser() {
		try {
			Gson gson = new Gson();
			String json = gson.toJson(stockarray);
			FileWriter filewrite = new FileWriter(
					"C:\\Users\\Shriniwas Pathak\\eclipse-workspace\\Stock\\src\\com\\bridgelab\\stock\\resources\\stock.json");
			filewrite.write(json);
			filewrite.close();

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	@Override
	public void writeCompany() {
		try {
			Gson gson = new Gson();
			String json = gson.toJson(companyarray);
			FileWriter filewrite = new FileWriter(
					"C:\\Users\\Shriniwas Pathak\\eclipse-workspace\\Stock\\src\\com\\bridgelab\\stock\\resources\\writejack.json");
			filewrite.write(json);
			filewrite.close();

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
