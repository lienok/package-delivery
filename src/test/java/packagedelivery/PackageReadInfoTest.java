package packagedelivery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PackageReadInfoTest {

	PackageReadInfo app;

	@Before
	public void init() {
		app = new PackageReadInfo();
	}
	
	//Test on the whole input 

	@Test
	public void shouldRecognizeQuitInput() {
		String input = " quit ";
		assertEquals("quit", app.cleanInput(input));
	}

	@Test
	public void shouldParseCorrectInput() {
		String input = "3.4 08801";
		Package pck = new Package(3.4, "08801");

		assertEquals(pck.getPostalCode(), app.parsePackageInfo(input).getPostalCode());
		assertEquals(pck.getWeight(), app.parsePackageInfo(input).getWeight(), 0.01);
	}
	
	//Test on validation of the input
	
	@Test
	public void shouldValidateInput() {
		String input = "3.4 08801";		
		assertTrue(app.validInput(input));
	}
	
	@Test
	public void shouldNotValidateInput() {
		String input = "3.408801";		
		assertFalse(app.validInput(input));
	}
	
	//Test on validation of PostalCode
	
	@Test
	public void shouldValidatePostalCode() {
		String input = "08801";		
		assertTrue(app.validPostalCode(input));
	}
	
	@Test
	public void shouldNotValidatePostalCodeLessThanFifeChars() {
		String input = "0880";		
		assertFalse(app.validPostalCode(input));
	}
	
	@Test
	public void shouldNotValidatePostalCodeContainingSpace() {
		String input = "088 01";		
		assertFalse(app.validPostalCode(input));
	}
	
	//Test on validation of Weight
	
	@Test
	public void shouldValidateWeight() {
		String input = "3.4";		
		assertTrue(app.validWeight(input));
	}
	
	@Test
	public void shouldNotValidateNegativeWeight() {
		String input = "-3.4";		
		assertFalse(app.validWeight(input));
	}
	
	@Test
	public void shouldNotValidateTooManyDecimals() {
		String input = "3.4434";		
		assertFalse(app.validWeight(input));
	}
	
	@Test
	public void shouldValidateWeightUntilThreeDecimals() {
		String input = "3.443";		
		assertTrue(app.validWeight(input));
	}
	
	@Test
	public void shouldNotValidateNotDouble() {
		String input = "3.4 54";		
		assertFalse(app.validWeight(input));
	}
}
