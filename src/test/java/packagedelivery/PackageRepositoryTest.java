package packagedelivery;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import packagedelivery.Package;
import packagedelivery.PackageRepository;

public class PackageRepositoryTest {

	PackageRepository repo;

	@Before
	public void init() {
		repo = new PackageRepository();
	}
	
	
	@Test
	public void shouldSumUpWeightsForTheGivenPostalCode() {
		repo.addPackage(new Package(3.4, "09809"));
		repo.addPackage(new Package(3.4, "09809"));
		
		Map<String, Double> summary = repo.getWeightsByPostalCode();
		double summaryOf02601 = 6.8;
		
		assertEquals(summaryOf02601, summary.get("09809").doubleValue(), 0.001);
	}

	@Test
	public void shouldReturnSumOfWeightGroupedByPostalNumbers() {
		repo.addPackage(new Package(3.7, "02601"));
		repo.addPackage(new Package(1.4, "02601"));
		repo.addPackage(new Package(1.6, "01008"));
		repo.addPackage(new Package(2.4, "01008"));		
		
		Map<String, Double> summary = repo.getWeightsByPostalCode();
		double sumOf02601 = 5.1;
		double sumOf01008 = 4;
		
		assertEquals(sumOf01008, summary.get("01008").doubleValue(), 0.001);
		assertEquals(sumOf02601, summary.get("02601").doubleValue(), 0.001);
	}

}
