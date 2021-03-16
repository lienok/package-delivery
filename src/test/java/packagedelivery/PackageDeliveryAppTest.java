package packagedelivery;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import packagedelivery.Package;

public class PackageDeliveryAppTest {

	PackageDeliveryApp app;

	@Before
	public void init() {
		app = new PackageDeliveryApp();
	}

	@Test
	public void shouldTakeUserInput() {

		String input = "add 5";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("add 5", app.getInput());
	}

	@Test
	public void shouldParseInputAndReturnPackageObject() {
		String input = "3.4 08801";
		Package pck = new Package(3.4, "08801");

		assertEquals(pck.getPostalCode(), app.parsePackageInput(input).getPostalCode());
		assertEquals(pck.getWeight(), app.parsePackageInput(input).getWeight(), 0.01);
	}

}
