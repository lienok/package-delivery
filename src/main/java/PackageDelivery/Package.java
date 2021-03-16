package PackageDelivery;

public class Package {
	private double weight;
    private String postalCode;
    
    public Package(double weight, String postalCode) {
        this.weight = weight;
        this.postalCode = postalCode;
    }
    
    public String getPostalCode() {
		return postalCode;
	}
    
    public double getWeight() {
		return weight;
	}
}
