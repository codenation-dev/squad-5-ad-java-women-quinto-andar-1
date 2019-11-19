package br.com.quintoandar.sakuraerrorcaptor.error;

public class TenantNotFound extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4556680139597382816L;

	public TenantNotFound(){
        super("Tenant not found.");
    }
}
