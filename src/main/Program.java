package main;

import java.util.List;

import core.ChainSequence;
import core.IXerofScanner;
import core.Variant;
import core.XerofScanner;
import test.ChainSequenceGenerator;
import test.IChainSequenceGenerator;

public class Program {
	
	static IChainSequenceGenerator chainGenerator;
	static IXerofScanner xerofScanner;

	public static void main(String [] args) {
		chainGenerator = new ChainSequenceGenerator();
		xerofScanner = new XerofScanner();
		xerofScanner.setAttributes(7, 2);
		
		ChainSequence chainSequence = chainGenerator.Generate(25);
		
		xerofScanner.loadCharSequence(chainSequence);
		List<Variant> length2 = xerofScanner.getPatterns(2);
		List<Variant> length3 = xerofScanner.getPatterns(3);
		List<Variant> length4 = xerofScanner.getPatterns(4);
		List<Variant> length5 = xerofScanner.getPatterns(5);
		
		double lengthAccuracy = 0.0;
		int totalFrequency = xerofScanner.getTotalFrequency();
		
		lengthAccuracy = 0.0;
		for(Variant variant : length2) {
			System.out.println("Value: "+variant.getValue()+",\tFrequency: "+variant.getFrequency()+", \tGlobal Accuracy: "+variant.getGlobalAccuracy()+"% ");
			lengthAccuracy += variant.getLengthAccuracy();
		}
		
		System.out.println("\nLength Accuracy: "+lengthAccuracy+"%\n");
		
		lengthAccuracy = 0.0;
		for(Variant variant : length3) {
			System.out.println("Value: "+variant.getValue()+",\tFrequency: "+variant.getFrequency()+", \tGlobal Accuracy: "+variant.getGlobalAccuracy()+"% ");
			lengthAccuracy += variant.getLengthAccuracy();	
		}
		
		System.out.println("\nLength Accuracy: "+lengthAccuracy+"%\n");
		
		lengthAccuracy = 0.0;
		for(Variant variant : length4) {
			System.out.println("Value: "+variant.getValue()+",\tFrequency: "+variant.getFrequency()+", \tGlobal Accuracy: "+variant.getGlobalAccuracy()+"% ");
			lengthAccuracy += variant.getLengthAccuracy();	
		}
		
		System.out.println("\nLength Accuracy: "+lengthAccuracy+"%\n");
		
		lengthAccuracy = 0.0;
		for(Variant variant : length5) {
			System.out.println("Value: "+variant.getValue()+",\tFrequency: "+variant.getFrequency()+", \tGlobal Accuracy: "+variant.getGlobalAccuracy()+"% ");
			lengthAccuracy += variant.getLengthAccuracy();			
		}
		
		System.out.println("\nLength Accuracy: "+lengthAccuracy+"%");		
		
	}
}
