package br.com.quintoandar.sakuraerrorcaptor.error;

public class TrackedSystemNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4544819369945164707L;

	public TrackedSystemNotFound(String token) {
		super("TrackedSystem with token "+token+" not found.");
	}
}
