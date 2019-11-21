package br.com.quintoandar.sakuraerrorcaptor.error;

public class EnvironmentNotFound extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1314209234010325188L;

	public EnvironmentNotFound(String environment){
        super("Environment " + environment + " not found.");
    }
}
