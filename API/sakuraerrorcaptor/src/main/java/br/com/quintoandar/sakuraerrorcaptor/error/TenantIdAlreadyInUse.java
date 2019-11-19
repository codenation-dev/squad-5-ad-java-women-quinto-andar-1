package br.com.quintoandar.sakuraerrorcaptor.error;

public class TenantIdAlreadyInUse extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3151540305342479182L;

	public TenantIdAlreadyInUse(){
        super("Tenant id already in use. To create a new tenant, use a null id.");
    }
}
