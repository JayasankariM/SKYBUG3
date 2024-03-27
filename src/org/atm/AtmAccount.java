package org.atm;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AtmAccount {
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance=0;
	private double savingBalance=0;
	
	Scanner s=new Scanner(System.in);
	DecimalFormat df=new DecimalFormat("'s'###,##0.00");
	public AtmAccount() {
		
	}
	public AtmAccount(int customerNumber,int pinNumber) {
		this.customerNumber=customerNumber;
		this.pinNumber=pinNumber;
	}
	public AtmAccount(int customerNumber,int pinNumber,double checkingBalance,double savingBalance) {
		this.customerNumber=customerNumber;
		this.pinNumber=pinNumber;
		this.checkingBalance=checkingBalance;
		this.savingBalance=savingBalance;
	}	
	public int getCustomerNumber() {
		return customerNumber;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public double getSavingBalance() {
		return savingBalance;
	}
	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}
	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}
	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance-amount);
		return checkingBalance;
		
	}
	public double calcsavingwithdraw(double amount) {
		this.savingBalance = (savingBalance-amount);
		return savingBalance;
	}
	public double calcCheckingDeposit(double amount) {
		checkingBalance=(checkingBalance+amount);
		return checkingBalance;
	}
	public void calcCheckTransfer(double amount) {
		checkingBalance=checkingBalance-amount;
		savingBalance=savingBalance+amount;
	}
	public void calcSavingTransfer(double amount) {
		savingBalance=savingBalance-amount;
		checkingBalance=checkingBalance+amount;
	}
	public void getCheckingWithdrawInput() {
		boolean end=false;
		while(!end) {
			try {
				System.out.println("\nCurrent Checking Account Balance:" +df.format(checkingBalance));
			    System.out.print("\nAmount you want to Withdraw from checkings Account:");
			     double amount=s.nextDouble();
			     if((checkingBalance-amount)>=0 && amount >=0) {
			    	 calcCheckingWithdraw(amount);
			    	 System.out.println("\nCurrent Checkings Accont Balance:"+df.format(checkingBalance));
			    	 end=true;
			     }
			     else {
			    	 System.out.println("\nBalance Cannot be Negative");
			     }
			}catch(InputMismatchException e) {
				System.out.println("\n Invalid Choice");
				s.next();
			}
		}
	}
		
	public void getsavingWithdrawInput() {
		boolean end=false;
		while(!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance:" +df.format(checkingBalance));
			    System.out.print("\nAmount you want to Withdraw from savings Account:");
			     double amount=s.nextDouble();
			     if((savingBalance-amount)>=0 && amount >=0) {
			    	 calcsavingwithdraw(amount);
			    	 System.out.println("\nCurrent Savings Accont Balance:"+df.format(checkingBalance));
			    	 end=true;
			     }
			     else {
			    	 System.out.println("\nBalance Cannot be Negative");
			     }
			}catch(InputMismatchException e) {
				System.out.println("\n Invalid Choice");
				s.next();
			}
		}
	}
	public void getCheckingDepositInput() {
		boolean end=false;
	while(!end) {
		try {
			System.out.println("\nCurrent Checking Account Balance:" +df.format(checkingBalance));
		    System.out.print("\nAmount you want to deposit from checkings Account:");
		     double amount=s.nextDouble();
		     if((checkingBalance+amount)>=0 && amount >=0) {
		    	 calcCheckingDeposit(amount);
		    	 System.out.println("\nCurrent Checkings Accont Balance:"+df.format(checkingBalance));
		    	 end=true;
		     }
		     else {
		    	 System.out.println("\nBalance Cannot be Negative");
		     }
		}catch(InputMismatchException e) {
			System.out.println("\n Invalid Choice");
			s.next();
		}
	}
	}
	public void getSavingDepositInput() {
		boolean end=false;
	
	
	while(!end) {
		try {
			System.out.println("\nCurrent Saving Account Balance:" +df.format(checkingBalance));
		    System.out.print("\nAmount you want to deposit from checkings Account:");
		     double amount=s.nextDouble();
		     if((savingBalance+amount)>=0 && amount >=0) {
		    	 calcCheckingWithdraw(amount);
		    	 System.out.println("\nCurrent Savings Accont Balance:"+df.format(checkingBalance));
		    	 end=true;
		     }
		     else {
		    	 System.out.println("\nBalance Cannot be Negative");
		     }
		}catch(InputMismatchException e) {
			System.out.println("\n Invalid Choice");
			s.next();
		}
	}	     
			
	}
	public void getTransferInput(String accType) {
		boolean end=false;
		while(!end) {
			try {
				if(accType.equals("Checkings")) {
					System.out.println("\n Select an account you wish to transfers funds to:");
					System.out.println("1. Savings");
					System.out.println("2. Exit");
					System.out.println("\nChoice");
					int choice=s.nextInt();
					switch(choice) {
					case 1:
						System.out.println("\nCurrent Checkings Account Balance:" +df.format(checkingBalance));
						System.out.println("\nAmount you want to deposit into Your Savings Account:");
						double amount=s.nextDouble();
						if((savingBalance+amount)>=0 && (checkingBalance-amount)>=0 && amount >=0) {
							calcCheckTransfer(amount);
							
							System.out.println("\nCurrent Savings Account Balance:"+df.format(savingBalance));
							System.out.println("\nCurrent Checkings Account Balance:"+df.format(checkingBalance));
						end=true;
						}else {
							System.out.println("\nBalance Cannot be Negative");
						}
						break;
					case 2:
						return;
						default:
							System.out.println("\nInvalid Choice");
							break;
					}
					
				}else if(accType.equals("Savings")) {
					System.out.println("\n Select an account you wish to transfers funds to:");
					System.out.println("1. Checkings");
					System.out.println("2. Exit");
					System.out.println("\nChoice");
					int choice=s.nextInt();
					switch(choice) {
					case 1:
						System.out.println("\nCurrent Savings Account Balance:" +df.format(checkingBalance));
						System.out.println("\nAmount you want to deposit into Your Savings Account:");
						double amount=s.nextDouble();
						if((savingBalance+amount)>=0 && (savingBalance-amount)>=0 && amount >=0) {
							calcCheckTransfer(amount);
							
							System.out.println("\nCurrent Checkings Account Balance:"+df.format(checkingBalance));
							System.out.println("\nCurrent savings Account Balance:"+df.format(savingBalance));
						end=true;
						}else {
							System.out.println("\nBalance Cannot be Negative");
						}
						break;
					case 2:
						return;
						default:
							System.out.println("\nInvalid Choice");
							break;
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("\nInvalid Choice");
			s.next();
		}
	}
		
	
	
	
	}
}