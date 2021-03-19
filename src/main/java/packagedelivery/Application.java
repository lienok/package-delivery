package packagedelivery;

import java.util.Timer;

public class Application {

	public static void main(String[] args) {
		
		PackageRepository packageRepo = new PackageRepository();
		
		long minuteOne = 1 * 60 * 1000;
		new Timer(true).schedule(new SummaryNotification(packageRepo), minuteOne, minuteOne);
		
		System.out.println("--- Welcome in Package Delivery Application---");
		new PackageReadInfo().readInput(packageRepo);
	}
}
