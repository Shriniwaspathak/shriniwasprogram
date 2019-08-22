package com.bridgelab.addressbook1.main;

import com.bridgelab.addressbook1.implementation.AddressBookImplementation;
import com.bridgelab.addressbook1.util.Util;

public class AddressBookMain extends AddressBookImplementation {
	public static void main(String[] args) {
		AddressBookMain main = new AddressBookMain();
		//AddressBookImplementation implement=new AddressBookImplementation();
		System.out.println("Enter 1 for Add in AddressBook");
		System.out.println("Enter 2 for Edit in AddressBook");
		System.out.println("Enter 3 for Remove in AddressBook");
		int choose = Util.inputInteger();
		switch (choose) {
		case 1:
			System.out.println("Enter Details for Adding");
			main.add();
			break;
		case 2:
			System.out.println("Enter Phone Number for Edit");
			String phonenumber = Util.inputString();
			main.edit(phonenumber);
			break;
		case 3:
			System.out.println("Enter Phone Number for Remove  ");
			String phoneNumber = Util.inputString();
			main.remove(phoneNumber);
			break;
		}
	}

}
