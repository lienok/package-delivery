package packagedelivery;

import java.util.TimerTask;

public class SummaryNotification extends TimerTask {
	
	private PackageRepository repo;
	
	public SummaryNotification(PackageRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public void run() {
		System.out.println("\n Summary: ");
			
		repo.getWeightsByPostalCode().forEach((postalCode, sum) -> System.out.print(String.format("%s: %.3f", postalCode, sum)));
		System.out.println();
	}
	

}
