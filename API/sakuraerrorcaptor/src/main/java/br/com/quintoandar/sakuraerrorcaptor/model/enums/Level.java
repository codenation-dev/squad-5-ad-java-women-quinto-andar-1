package br.com.quintoandar.sakuraerrorcaptor.model.enums;

import br.com.quintoandar.sakuraerrorcaptor.error.LevelNotFound;

public enum Level {
    ERROR,
    WARNING,
    DEBUG;
    
    public static boolean isFound(String value) {
    	try{
    		Level.valueOf(value);
			return true;
		}catch (Exception e) {
			throw new LevelNotFound(value);
		}
    }
}
