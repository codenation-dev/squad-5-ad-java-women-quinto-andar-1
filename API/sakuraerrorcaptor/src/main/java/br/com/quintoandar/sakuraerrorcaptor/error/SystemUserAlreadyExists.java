package br.com.quintoandar.sakuraerrorcaptor.error;

public class SystemUserAlreadyExists extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2170706920279144655L;
	
	public SystemUserAlreadyExists(String email) {
		super("Email already in use by another user");
	}
}
