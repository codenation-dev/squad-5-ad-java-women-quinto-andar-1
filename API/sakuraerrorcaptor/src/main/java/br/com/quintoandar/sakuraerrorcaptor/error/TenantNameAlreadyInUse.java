package br.com.quintoandar.sakuraerrorcaptor.error;

public class TenantNameAlreadyInUse extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5707557780794448119L;

	public TenantNameAlreadyInUse(){
        super("Tenant name already in use.");
    }
}
