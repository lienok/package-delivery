package packagedelivery;

import java.math.BigDecimal;
import java.util.Scanner;

public class PackageReadInfo {
	
	public void readInput(PackageRepository repo) {
		System.out.println("Please enter the package info and press ENTER \n");

		boolean quit = false;
		try (Scanner sc = new Scanner(System.in)) {
			while (!quit) {
				try {
					String s = this.cleanInput(sc.nextLine());
					if (s.equals("quit")) {
						break;
					}
					Package p = this.parsePackageInfo(s);
					if (p != null) {
						repo.addPackage(p);
					} else {
						System.out.println("Wrong format of input. Please read the manual. \n");
					}
				} catch (Exception e) {
					System.out.print("Something unexpected. \n" + e);
				}
			}
		} 
	}

	public String cleanInput(String s) {
		return s.trim();
	}

	public Package parsePackageInfo(String packageEnteredInput) {
		if (validInput(packageEnteredInput)) {
			String[] packageInput = packageEnteredInput.split(" ");
			
			String expectedWeight = packageInput[0];
			String expectedPostalCode = packageInput[1];	
			
			if (validWeight(expectedWeight) && validPostalCode(expectedPostalCode)) {
				double weight = Double.parseDouble(packageInput[0]);
				return new Package(weight, expectedPostalCode);		
			}
		}
		
		return null;
	}
	

	public boolean validInput(String packageEnteredInput) {
		boolean containsSpace = packageEnteredInput.contains(" ");		
		
		return containsSpace;
	}
		
	public boolean validPostalCode(String s) {
		boolean postalCodeLengthIsFive = s.length() == 5;
		boolean containsSpace = s.contains(" ");
		
		return !containsSpace && postalCodeLengthIsFive;
	}

	public boolean validWeight(String s) {
		try {
			double d = Double.parseDouble(s);		
			boolean tooManyDecimals = (BigDecimal.valueOf(d).scale() > 3);
			boolean negative = d < 0;
			
			return !tooManyDecimals && !negative;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
