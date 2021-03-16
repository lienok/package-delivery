package PackageDelivery;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class PackageRepositoryTest {

	PackageRepository repo;

	@Before
	public void init() {
		repo = new PackageRepository();
		//Prepare testing data
		repo.getPackages().add(new Package(3.7, "02601"));
		repo.getPackages().add(new Package(1.4, "02601"));
		repo.getPackages().add(new Package(1.6, "01008"));
		repo.getPackages().add(new Package(2.4, "01008"));

	}

	@Test
	public void shouldReturnSumOfWeightGroupedByPostalNumbers() {
		Map<String, Double> summary = repo.getSummaryOfPackages();
		double summaryOf02601 = 5.1;
		double summaryOf01008 = 4;
		
		assertEquals(summaryOf02601, summary.get("02601").doubleValue(), 0.001);
		assertEquals(summaryOf01008, summary.get("01008").doubleValue(), 0.001);
	}


}
