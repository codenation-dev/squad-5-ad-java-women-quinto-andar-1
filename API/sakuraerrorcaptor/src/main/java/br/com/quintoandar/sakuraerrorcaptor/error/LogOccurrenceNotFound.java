package br.com.quintoandar.sakuraerrorcaptor.error;

public class LogOccurrenceNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5625272890907113792L;
	public LogOccurrenceNotFound() {
		super("LogOccurrence not found");
	}
}
