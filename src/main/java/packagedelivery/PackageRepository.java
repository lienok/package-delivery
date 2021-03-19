package packagedelivery;

import java.util.HashMap;
import java.util.Map;

public class PackageRepository {

	Map<String, Double> packages = new HashMap<String, Double>();

	public Map<String, Double> getWeightsByPostalCode() {
		return packages;
	}
	
	public synchronized void addPackage(Package p) { 
		double currentWeight = 0;
		if (this.getWeightsByPostalCode().containsKey(p.getPostalCode())) {
			currentWeight = this.getWeightsByPostalCode().get(p.getPostalCode());
		}
		
		this.getWeightsByPostalCode().put(p.getPostalCode(), currentWeight + p.getWeight());
	}
}
