package br.com.quintoandar.sakuraerrorcaptor.error;

public class SystemUserNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 public SystemUserNotFound(Long id){
	        super("SystemUser with id " + id + " not found.");
	 }
	 
	 public SystemUserNotFound(String email){
	        super("SystemUser with email " + email + " not found.");
	 }
	 
	 public SystemUserNotFound(Long id, String email){
	        super("Password and email doesn't match for user " + id + ".");
	 }
}
