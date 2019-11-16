package br.com.quintoandar.sakuraerrorcaptor.exception;

public class ArchiveNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7290410307581559262L;

	public ArchiveNotFoundException(Long id) {
		super("Archive with id " + id + " not found.");
	}
}
