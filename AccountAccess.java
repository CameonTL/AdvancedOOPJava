package assignment3;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class AccountAccess {
	
	public static void main(String[] args) {

	String[][] accounts = new String[5][4];
	Path productsPath = Paths.get("accounts.txt");
//	Scanner input = new Scanner(Paths.get("/⁨Users⁩/⁨cameronleathers/⁨Desktop⁩/2020 Java/accounts.txt"⁩));
	File productsFile = productsPath.toFile();{
	
		try (BufferedReader infile = new BufferedReader(new FileReader(productsFile))) {
			String line = infile.readLine();
			for (int i = 0; i < 5; i++) {
				String[] columns = line.split(",");
				accounts[i][0] = columns[0];
				accounts[i][1] = columns[1];
				accounts[i][2] = columns[2];
				accounts[i][3] = columns[3];
				line = infile.readLine();
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Credit Inquiry");
		System.out.println();
		
		System.out.printf("%nEnter request%n%s%n%s%n%s%n%s%n",
				"1 - List accounts with zero balances",
				"2 - List accounts with credit balances", 
				"3 - List accounts with debit balances",
				"4 - Terminate program");
		System.out.println();
		
		System.out.println("Enter your selection: ");
		String choice = sc.nextLine();
		if (choice.contentEquals("1")) {
			for (int i = 0; i < 5; i++) {
				if (Integer.parseInt(accounts[i][3]) == 0) {
					System.out.println(accounts[i][0] + "\t" +
							accounts[i][1] + "\t" +
							accounts[i][2] + "\t" +
							accounts[i][3]);
				}
			}
		}
		else if (choice.contentEquals("2")) {
			for (int j = 0; j < 5; j++) {
				if (Integer.parseInt(accounts[j][3]) < 0) {
					System.out.println(accounts[j][0] + "\t" +
							accounts[j][1] + "\t" +
							accounts[j][2] + "\t" +
							accounts[j][3]);
				}
			}
		}
		else if (choice.contentEquals("3")) {
			for (int k = 0; k < 5; k++) {
				if (Integer.parseInt(accounts[k][3]) > 0) {
					System.out.println(accounts[k][0] + "\t" +
							accounts[k][1] + "\t" +
							accounts[k][2] + "\t" +
							accounts[k][3]);
				}
			}
		}
		System.out.println("Bye");
		sc.close();
	}
}