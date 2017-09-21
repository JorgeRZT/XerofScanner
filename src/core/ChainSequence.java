package core;

public class ChainSequence {
	
	private String charSequence ;
	
	public ChainSequence(String _charSequence) {
		charSequence = _charSequence;
	}
	
	public int Length() {
		return charSequence.length();
	}

	public String getCharSequence() {
		return charSequence;
	}

	public void setCharSequence(String _charSequence) {
		charSequence = _charSequence;
	}

}
