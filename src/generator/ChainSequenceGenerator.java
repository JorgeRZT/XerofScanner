package generator;

import core.ChainSequence;

public class ChainSequenceGenerator implements IChainSequenceGenerator{

	/**
	 * U -> Up
	 * C -> Constant
	 * D -> Down
	 */
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

}
