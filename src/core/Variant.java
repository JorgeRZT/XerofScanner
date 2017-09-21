package core;

public class Variant {
	String value;
	int length;
	int frequency;
	double globalAccuracy;
	double thisLengthAccuracy;

	public double getGlobalAccuracy() {
		return globalAccuracy;
	}
	
	public double getLengthAccuracy() {
		return thisLengthAccuracy;
	}
	
	public Variant(String _value) {
		value = _value;
		length = _value.length();
		frequency = 1;
	}
	
	public String getValue() {
		return value;
	}
	
	public void addFrequency() {
		frequency++;
	}
	
	public int getFrequency() {
		return frequency;
	}

	public boolean isSameVariant(Variant variant) {
		
		System.out.println("Comparando "+value+" con "+variant.getValue());
		
		if(variant.getValue().equals(variant.getValue())) {
			return true;
		}
		return false;
	}
	
	
}
