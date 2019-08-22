package com.bridgelab.addressbook1.implementation;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelab.addressbook1.module.AddressBook;
import com.bridgelab.addressbook1.service.AddressBookService;
import com.bridgelab.addressbook1.util.Util;
import com.google.gson.Gson;

public class AddressBookImplementation implements AddressBookService {

	Gson gson = new Gson();
	List<AddressBook> address = new ArrayList<AddressBook>();
	ReadWrite read = new ReadWrite();

	public AddressBookImplementation() {
		JSONParser parser = new JSONParser();
		try {
			JSONArray array = (JSONArray) parser.parse(new FileReader(
					"C:\\Users\\Shriniwas Pathak\\eclipse-workspace\\AddressBook1\\src\\com\\bridgelab\\addressbook\\result\\addressbook1.json"));
			for (Object object : array) {
				JSONObject object1 = (JSONObject) object;
				AddressBook module = new AddressBook();
				module.setFirstName((String) object1.get("FirstName"));
				module.setLastName((String) object1.get("lastName"));
				module.setAddress((String) object1.get("Address"));
				module.setCity((String) object1.get("city"));
				module.setState((String) object1.get("State"));
				module.setZipCode((String) object1.get("ZipCode"));
				module.setPhoneNumber((String) object1.get("PhoneNumber"));
				address.add(module);

			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add() {
		try {
			AddressBook module = new AddressBook();
			JSONObject object1 = new JSONObject();

			System.out.println("First Name");
			String firstName = Util.inputString();
			module.setFirstName(firstName);

			System.out.println("Last Name");
			String lastName = Util.inputString();
			module.setLastName(lastName);

			System.out.println("Address");
			String addresss = Util.inputString();
			module.setAddress(addresss);

			System.out.println("City");
			String city = Util.inputString();
			module.setCity(city);

			System.out.println("State");
			String state = Util.inputString();
			module.setState(state);

			System.out.println("Zip code");
			String zipcode = Util.inputString();
			module.setZipCode(zipcode);

			System.out.println("Phone Number");
			String phonenumber = Util.inputString();
			module.setPhoneNumber(phonenumber);

			address.add(module);
			read.writeToJson(address);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(String phonenumber) {
		try {
			System.out.println(address);
			for (AddressBook model : address) {
				if (model.getPhoneNumber().equals(phonenumber)) {
					System.out.println("Enter Address");
					String address = Util.inputString();
					model.setAddress(address);

					System.out.println("Enter city name");
					String city = Util.inputString();
					model.setCity(city);

					System.out.println("Enter state name");
					String state = Util.inputString();
					model.setState(state);

					System.out.println("Enter zip code");
					String zipcode = Util.inputString();
					model.setZipCode(zipcode);

				}
			}
			read.writeToJson(address);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void remove(String phonenumber) {
		try {
			String json = null;
			AddressBook addressbook = new AddressBook();
			for (AddressBook model : address) {
				if (model.getPhoneNumber().equals(phonenumber)) {
					address.remove(model);

				}
				read.writeToJson(address);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sort() {
		// try { address.sort((AddressBook b1,AddressBook
		// b2)->b1.getZipCode()-b2.getZipCode());
		// read.writeToJson(address);
		// }catch(Exception e) { e.printStackTrace(); }

	}

}
