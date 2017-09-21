package test;

import core.ChainSequence;

public interface IChainSequenceGenerator {
	
	/**
	 * Return a chain sequence with a determinated length of characters
	 * @param length
	 * @return
	 */
	ChainSequence Generate(int length);
	
	/**
	 * Return a random char 
	 * @return
	 */
	char GenerateRandomChar();
}
