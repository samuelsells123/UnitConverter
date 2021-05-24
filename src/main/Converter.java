package main;
import java.util.Scanner;

public class Converter {
	private static Scanner scan;
	private static Converter c;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		c = new Converter();
		int menuSelection = 0;
		
		while(menuSelection != 5) {
			System.out.println("Please select an option:");
			System.out.println("1. Distance Conversions");
			System.out.println("2. Temperature Conversions");
			System.out.println("3. Time Conversion");
			System.out.println("4. Volume Conversions");
			System.out.println("5. Quit");
			System.out.print("\nSelection: ");
			
			menuSelection = scan.nextInt();
			
			switch(menuSelection) {
				case 1:
					c.distanceMenu();
					break;
				case 2:
					c.tempMenu();
					break;
				case 3:
					c.timeMenu();
					break;
				case 4:
					c.volumeMenu();
					break;
				case 5:
					System.out.println("\nExiting Program");
					break;
				default:
					System.out.println("\nINAVLID INPUT\n");
			}
		}
		
		scan.close();
	}
	
	// Input Collection Method
	private static double collectQuantity(String unit1, String unit2) {
		System.out.println("\nConverting " + unit1 + " to " + unit2 + ".");
		System.out.print("Input Units in " + unit1 + ": ");
		
		return scan.nextDouble();
	}
	
	// Results Display Method
	private static void printQuantity(String unit1, double unitVal) {
		System.out.format("\nConverted Value: %.4f %s\n\n", unitVal, unit1);
	}
	
	// Second Menu Layer Methods
	public void distanceMenu() {
		System.out.println("\nPlease select a distance conversion:");
		System.out.println("1. Feet to Meters");
		System.out.println("2. Feet to Yards");
		System.out.println("3. Miles to Kilometers");
		System.out.print("\nSelection: ");
		
		int menuSelection = scan.nextInt();
		double convertVal = 0.0;
		
		switch(menuSelection) {
			case 1:
				convertVal = c.convertFeetToMeters(collectQuantity("Feet", "Meters"));
				Converter.printQuantity("Meters", convertVal);
				break;
			case 2:
				convertVal = c.convertFeetToYards(collectQuantity("Feet", "Yards"));
				Converter.printQuantity("Yards", convertVal);
				break;
			case 3:
				convertVal = c.convertMilesToKilometers(collectQuantity("Miles", "Kilometers"));
				Converter.printQuantity("Kilometers", convertVal);
				break;
			default:
				System.out.println("\nInvalid Input. Aborting Operation\n");
		}
	}
	
	public void tempMenu() {
		System.out.println("\nPlease select a temperature conversion:");
		System.out.println("1. Celsius to Fahrenheit");
		System.out.println("2. Celsius to Kelvin");
		System.out.println("3. Fahrenheit to Kelvin");
		System.out.println("4. Kelvin to Fahrenheit");
		System.out.print("\nSelection: ");
		
		int menuSelection = scan.nextInt();
		double convertVal = 0.0;
		
		switch(menuSelection) {
			case 1:
				convertVal = c.convertCelsiusToFahrenheit(collectQuantity("Celsius", "Fahrenheit"));
				Converter.printQuantity("Fahrenheit", convertVal);
				break;
			case 2:
				convertVal = c.convertCelsiusToKelvin(collectQuantity("Celsius", "Kelvin"));
				Converter.printQuantity("Kelvin", convertVal);
				break;
			case 3:
				convertVal = c.convertFahrenheitToKelvin(collectQuantity("Fahrenheit", "Kelvin"));
				Converter.printQuantity("Kelvin", convertVal);
				break;
			case 4:
				convertVal = convertKelvinToFahrenheit(collectQuantity("Kelvin", "Fahrenheit"));
				Converter.printQuantity("Fahrenheit", convertVal);
				break;
			default:
				System.out.println("\nInvalid Input. Aborting Operation\n");
		}
	}
	
	public void timeMenu() {
		System.out.println("\nPlease select a time conversion:");
		System.out.println("1. Weeks to Days");
		System.out.println("2. Days to Hours");
		System.out.println("3. Hours to Minutes");
		System.out.println("4. Hours to Seconds");
		System.out.print("\nSelection: ");
		
		int menuSelection = scan.nextInt();
		double convertVal = 0.0;
		
		switch(menuSelection) {
			case 1:
				convertVal = c.convertWeeksToDays(collectQuantity("Weeks", "Days"));
				Converter.printQuantity("Days", convertVal);
				break;
			case 2:
				convertVal = c.convertDaysToHours(collectQuantity("Days", "Hours"));
				Converter.printQuantity("Hours", convertVal);
				break;
			case 3:
				convertVal = c.convertHoursToMinutes(collectQuantity("Hours", "Minutes"));
				Converter.printQuantity("Minutes", convertVal);
				break;
			case 4:
				convertVal = convertHoursToSeconds(collectQuantity("Hours", "Seconds"));
				Converter.printQuantity("Seconds", convertVal);
				break;
			default:
				System.out.println("\nInvalid Input. Aborting Operation\n");
		}
	}
	
	public void volumeMenu() {
		System.out.println("\nPlease select a volume conversion:");
		System.out.println("1. Teaspoons to Cups");
		System.out.println("2. Teaspoons to Tablespoons");
		System.out.println("3. US Gallons to Imperial Gallons");
		System.out.print("\nSelection: ");
		
		int menuSelection = scan.nextInt();
		double convertVal = 0.0;
		
		switch(menuSelection) {
		case 1:
			convertVal = c.convertTeaspoonsToCups(collectQuantity("Teaspoons", "Cups"));
			Converter.printQuantity("Cups", convertVal);
			break;
		case 2:
			convertVal = c.convertTeaspoonsToTablespoons(collectQuantity("Teaspoons", "Tablespoons"));
			Converter.printQuantity("Tablespoons", convertVal);
			break;
		case 3:
			convertVal = c.convertUStoImperial(collectQuantity("US Gallons", "Imperial Gallons"));
			Converter.printQuantity("Imperial Gallons", convertVal);
			break;
		default:
			System.out.println("\nInvalid Input. Aborting Operation\n");
	}
	}

	// Distance Conversion Methods
	public double convertFeetToMeters(double qty) {
		return qty * .3048;
	}
	
	public double convertFeetToYards(double qty) {
		return qty / 3;
	}
	
	public double convertMilesToKilometers(double qty) {
		return qty * 1.60934;
	}
	
	// Temperature Conversion Methods
	public double convertCelsiusToFahrenheit(double qty) {
		return qty * 9/5 + 32;
	}
	
	public double convertCelsiusToKelvin(double qty) {
		return qty + 273.15;
	}
	
	public double convertFahrenheitToKelvin(double qty) {
		return (qty - 32) * 5/9 + 273.15;
	}
	
	public double convertKelvinToFahrenheit(double qty) {
		return (qty - 273.15) * 9/5 + 32;
	}
	
	// Time Conversion Methods
	public double convertWeeksToDays(double qty) {
		return qty *  7;
	}
	
	public double convertDaysToHours(double qty) {
		return qty * 24;
	}
	
	public double convertHoursToMinutes(double qty) {
		return qty * 60;
	}
	
	public double convertHoursToSeconds(double qty) {
		return qty * 3600;
	}
	
	// Volume Conversion Methods
	public double convertTeaspoonsToCups(double qty) {
		return qty / 48;
	}
	
	public double convertTeaspoonsToTablespoons(double qty) {
		return qty / 3;
	}
	
	public double convertUStoImperial(double qty) {
		return qty / 1.201;
	}
}