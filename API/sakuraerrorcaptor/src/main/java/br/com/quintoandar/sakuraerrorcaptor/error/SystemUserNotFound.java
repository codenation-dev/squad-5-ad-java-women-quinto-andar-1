package br.com.quintoandar.sakuraerrorcaptor.error;

public class SystemUserNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 public SystemUserNotFound(Long id){
	        super("SystemUser with id " + id + " not found.");
	    }
}
