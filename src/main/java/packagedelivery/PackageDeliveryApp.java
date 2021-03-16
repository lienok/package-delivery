package packagedelivery;

import java.util.Scanner;
import java.util.concurrent.*;

public class PackageDeliveryApp {

	public static void main(String[] args) {

		PackageDeliveryApp app = new PackageDeliveryApp();
		System.out.println("--- !!! App WORK IN PROGRESS not working yet. ");
		System.out.println("Please enter package info and press ENTER ");
		String s = app.getInput();
		
		Runnable notifaction = new SummaryNotification();
		Thread notificationThread = new Thread(notifaction);
		notificationThread.setDaemon(true);
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
		exec.scheduleAtFixedRate(notifaction, 0, 1, TimeUnit.MINUTES);
		
	}

	public String getInput() {
		try (Scanner sc = new Scanner(System.in)) {
			return sc.nextLine();
		}
	}
	
	public Package parsePackageInput(String packageEnteredInput) {
		String[] packageInput = packageEnteredInput.split(" ");
		double weight = Double.parseDouble(packageInput[0]);
		
		return new Package(weight, packageInput[1]);
	}

}
