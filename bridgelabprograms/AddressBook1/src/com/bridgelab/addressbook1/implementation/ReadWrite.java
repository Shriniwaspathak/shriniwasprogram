package com.bridgelab.addressbook1.implementation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.bridgelab.addressbook1.module.AddressBook;
import com.google.gson.Gson;

public class ReadWrite {
	AddressBook module1 = new AddressBook();

	// Adding in Json File
	public void writeToJson(List<AddressBook> module) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(module);
		FileWriter filewrite = new FileWriter(
				"C:\\Users\\Shriniwas Pathak\\eclipse-workspace\\AddressBook1\\src\\com\\bridgelab\\addressbook\\result\\addressbook1.json");
		filewrite.write(json);
		filewrite.close();
	}

}
