package org.atm;

import java.io.IOException;

public class MainAtm {
	public static void main(String[] args)throws IOException{
		Atmoption atm=new Atmoption();
		intro();
		atm.mainMenu();
	}
public static void intro() {
	System.out.println("Welcome to Atm");
}
}
