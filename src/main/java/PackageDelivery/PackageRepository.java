package PackageDelivery;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

public class PackageRepository {

	List<Package> packages = new CopyOnWriteArrayList<Package>();

	public List<Package> getPackages() {
		return packages;
	}

	public synchronized Map<String, Double> getSummaryOfPackages() {
		Map<String, Double> result = new HashMap<String, Double>(); // dont need concurent here save memory not to
																	// create all the time new map

		packages.stream().forEach((p) -> result.put(p.getPostalCode(), 
				packages.stream().filter(this.packageWithPostalCode(p.getPostalCode()))
				.mapToDouble(x -> x.getWeight())
				.sum()));
		return result;
	}

	private synchronized Predicate<Package> packageWithPostalCode(String postalCode) {
		return p -> p.getPostalCode() == postalCode;
	}

}
