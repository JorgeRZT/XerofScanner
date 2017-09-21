package core;

import java.util.List;

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
