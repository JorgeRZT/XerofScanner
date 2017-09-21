package core;

import java.util.ArrayList;
import java.util.List;

public class XerofScanner implements IXerofScanner{
	
	//TODO:
	
	private ChainSequence chainSequence;
	private int minLength, maxLength;
	List<Variant> variants ;
	List<Variant> cleanVariants = new ArrayList<Variant>();
	List<Variant> rawVariants = new ArrayList<Variant>();
	int TotalFrequency ;
	
	@Override
	public void loadCharSequence(ChainSequence _chainSequence) {
		chainSequence = _chainSequence;
		System.out.println("Escanenado secuencia\n");
		for(int i = minLength ; i < maxLength; i++) {
			for(int j = 0; j < chainSequence.Length() - i; j++) {
				Variant newVariant = new Variant(chainSequence.getCharSequence().substring(j,j+i));
				rawVariants.add(newVariant);
			}
		}
		clasifyVariants();
		setGlobalAccuracy();
		setLengthAccuracy();
	}
	
	private void setLengthAccuracy() {
		for(int i = minLength ; i < maxLength; i++){
			setAccuracy(i);
		}
	}
	
	void setAccuracy(int length) {
		int totalfrequencyLength = 0;
		for(Variant variant : cleanVariants) {
			if(variant.length == length) {
				totalfrequencyLength += variant.getFrequency();
			}
		}
				
		for(Variant variant : cleanVariants) {
			if(variant.length == length) {
				variant.thisLengthAccuracy = (double)(variant.getFrequency()*100/(double)totalfrequencyLength);
			}
		}
	}

	private void setGlobalAccuracy() {
		for(Variant variant : cleanVariants) {
			variant.globalAccuracy = (double)(variant.getFrequency()*100/(double)TotalFrequency);
		}
	}

	public int getTotalFrequency() {
		return TotalFrequency;
	}
	
	void clasifyVariants() {
		int rep = 0;
		for(Variant variant : rawVariants) {
			rep = 0;
			 for(Variant variant2 : cleanVariants) {
				 if(variant.getValue().equals(variant2.getValue())) {
					 rep++;
					 variant2.addFrequency();
				 }
			 }
			 if(rep < 1) {
				 cleanVariants.add(variant);
			 }
		}
		
		for(Variant variant : cleanVariants) {
			TotalFrequency += variant.getFrequency();
		}
	}
	
	@Override
	public List<Variant> getPatterns(int length) {
		variants = new ArrayList<Variant>();
		for(Variant variant : cleanVariants) {
			if(variant.getValue().length() == length) {
				variants.add(variant);
			}
		}
		return variants;
	}

	@Override
	public void setAttributes(int _maxLength, int _minLength) {
		minLength = _minLength;
		maxLength = _maxLength;
	}
	
}
