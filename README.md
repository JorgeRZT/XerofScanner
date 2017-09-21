# XerofScanner
Chain Sequence Scanner

Imagine you want to scan a sequence looking for some specific patterns or frequencies.

XerofScanner contains a class named "ChainSequenceGenerator". This class generates a random chain of chars once you give a length for it.

The other class, named "XerofScanner" loads this sequence and give you every repetition frequency found in the chain dividing it in diferent length blocks. It analise the 
repetition rate globaly (wihtout regarding block length) and repetition rate by length (regarding block length).

### ChainChainGenerator.java

```java
char [] chars = {'U','C','D'};
	
@Override
public ChainSequence Generate(int length) {
	String sequence = "";
	for(int i = 0 ; i < length; i++) {
		sequence += GenerateRandomChar();
	}
	return new ChainSequence(sequence);
}

@Override
public char GenerateRandomChar() {
	return chars[(int) (Math.random()*3)];
}
```

### ChainSequence.java

```java
private String charSequence ;
	
public ChainSequence(String _charSequence) {
	charSequence = _charSequence;
}
```

### IXerofScanner.java (Interface)
```java
public interface IXerofScanner {

	/**
	 * Specify the min length and the max length you want to use for divice and scan the chain sequence
	 * @param _maxLength
	 * @param _minLength
	 */
	void setAttributes(int _maxLength, int _minLength);
	
	/**
	 * Load a chain Sequence
	 * @param _charSequence
	 */
	void loadCharSequence(ChainSequence _charSequence);
	
	/**
	 * Return a list of variants based on the main chain sequence and with a specific length
	 * @param length
	 * @return
	 */
	List<Variant> getPatterns(int length);
	
	/**
	 * Return total amount of frequencies 
	 * @return
	 */
	int getTotalFrequency();
}
```

## Configuration of Scanner and chain generation
```java
//Create a random ChainSequenceGenerator and a XerofScanner 
ChainSequenceGenerator chainGenerator = new ChainSequenceGenerator();
IXerofScanner xerofScanner = new XerofScanner();

//Set the min and max length of block for scanning the chain
xerofScanner.setAttributes(7, 2);

//Set the size of the chain
ChainSequence chainSequence = chainGenerator.Generate(25);
		
//Load and scan the chain using the scanner
xerofScanner.loadCharSequence(chainSequence);
```

This is an example of the output. The sequence is based on a chain composed by 3 diferent chars (C,U,D)
```
Scanning sequence

Value: UD,	Frequency: 6, 	Length Accuracy: 26.08695652173913%, 	Global Accuracy: 5.714285714285714% 
Value: DU,	Frequency: 5, 	Length Accuracy: 21.73913043478261%, 	Global Accuracy: 4.761904761904762% 
Value: UC,	Frequency: 3, 	Length Accuracy: 13.043478260869565%, 	Global Accuracy: 2.857142857142857% 
Value: CU,	Frequency: 3, 	Length Accuracy: 13.043478260869565%, 	Global Accuracy: 2.857142857142857% 
Value: CC,	Frequency: 1, 	Length Accuracy: 4.3478260869565215%, 	Global Accuracy: 0.9523809523809523% 
Value: DD,	Frequency: 3, 	Length Accuracy: 13.043478260869565%, 	Global Accuracy: 2.857142857142857% 
Value: DC,	Frequency: 1, 	Length Accuracy: 4.3478260869565215%, 	Global Accuracy: 0.9523809523809523% 
Value: UU,	Frequency: 1, 	Length Accuracy: 4.3478260869565215%, 	Global Accuracy: 0.9523809523809523% 

Length Accuracy: 99.99999999999997%

Value: UDU,	Frequency: 5, 	Length Accuracy: 22.727272727272727%, 	Global Accuracy: 4.761904761904762% 
Value: DUC,	Frequency: 2, 	Length Accuracy: 9.090909090909092%, 	Global Accuracy: 1.9047619047619047% 
Value: UCU,	Frequency: 1, 	Length Accuracy: 4.545454545454546%, 	Global Accuracy: 0.9523809523809523% 
Value: CUC,	Frequency: 1, 	Length Accuracy: 4.545454545454546%, 	Global Accuracy: 0.9523809523809523% 
Value: UCC,	Frequency: 1, 	Length Accuracy: 4.545454545454546%, 	Global Accuracy: 0.9523809523809523% 
Value: CCU,	Frequency: 1, 	Length Accuracy: 4.545454545454546%, 	Global Accuracy: 0.9523809523809523% 
Value: CUD,	Frequency: 1, 	Length Accuracy: 4.545454545454546%, 	Global Accuracy: 0.9523809523809523% 
Value: DUD,	Frequency: 3, 	Length Accuracy: 13.636363636363637%, 	Global Accuracy: 2.857142857142857% 
Value: UDD,	Frequency: 1, 	Length Accuracy: 4.545454545454546%, 	Global Accuracy: 0.9523809523809523% 
Value: DDD,	Frequency: 2, 	Length Accuracy: 9.090909090909092%, 	Global Accuracy: 1.9047619047619047% 
Value: DDC,	Frequency: 1, 	Length Accuracy: 4.545454545454546%, 	Global Accuracy: 0.9523809523809523% 
Value: DCU,	Frequency: 1, 	Length Accuracy: 4.545454545454546%, 	Global Accuracy: 0.9523809523809523% 
Value: CUU,	Frequency: 1, 	Length Accuracy: 4.545454545454546%, 	Global Accuracy: 0.9523809523809523% 
Value: UUD,	Frequency: 1, 	Length Accuracy: 4.545454545454546%, 	Global Accuracy: 0.9523809523809523% 

Length Accuracy: 100.00000000000001%

Value: UDUC,	Frequency: 2, 	Length Accuracy: 9.523809523809524%, 	Global Accuracy: 1.9047619047619047% 
Value: DUCU,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: UCUC,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: CUCC,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: UCCU,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: CCUD,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: CUDU,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: UDUD,	Frequency: 3, 	Length Accuracy: 14.285714285714286%, 	Global Accuracy: 2.857142857142857% 
Value: DUDU,	Frequency: 2, 	Length Accuracy: 9.523809523809524%, 	Global Accuracy: 1.9047619047619047% 
Value: DUDD,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: UDDD,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: DDDD,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: DDDC,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: DDCU,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: DCUU,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: CUUD,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 
Value: UUDU,	Frequency: 1, 	Length Accuracy: 4.761904761904762%, 	Global Accuracy: 0.9523809523809523% 

Length Accuracy: 99.99999999999999%

Value: UDUCU,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: DUCUC,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: UCUCC,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: CUCCU,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: UCCUD,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: CCUDU,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: CUDUD,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: UDUDU,	Frequency: 2, 	Length Accuracy: 10.0%, Global Accuracy: 1.9047619047619047% 
Value: DUDUD,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: UDUDD,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: DUDDD,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: UDDDD,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: DDDDC,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: DDDCU,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: DDCUU,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: DCUUD,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: CUUDU,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: UUDUD,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 
Value: DUDUC,	Frequency: 1, 	Length Accuracy: 5.0%, 	Global Accuracy: 0.9523809523809523% 

Length Accuracy: 100.0%
```
