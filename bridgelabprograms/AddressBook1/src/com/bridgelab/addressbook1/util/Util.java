package com.bridgelab.addressbook1.util;

import java.util.Scanner;

public class Util {

	private static Scanner sc = new Scanner(System.in);

	public static int inputInteger() {
		return sc.nextInt();
	}

	public static String inputString() {
		return sc.next();
	}

	public static boolean inputBoolean() {
		return sc.nextBoolean();
	}

	public static double inputDouble() {
		return sc.nextDouble();
	}


}
