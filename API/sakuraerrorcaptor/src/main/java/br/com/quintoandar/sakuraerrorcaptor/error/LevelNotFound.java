package br.com.quintoandar.sakuraerrorcaptor.error;

public class LevelNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3431280329230114774L;

	public LevelNotFound(String value) {
		super("Level "+value+" not found.");
	}
}
