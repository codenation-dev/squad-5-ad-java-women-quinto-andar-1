package br.com.quintoandar.sakuraerrorcaptor.model.enums;

import br.com.quintoandar.sakuraerrorcaptor.error.EnvironmentNotFound;

public enum Environment {
    PRODUCTION,
    HOMOLOG,
    DEV;
    
    public static boolean isFound(String value) {
    	try{
			Environment.valueOf(value);
			return true;
		}catch (Exception e) {
			throw new EnvironmentNotFound(value);
		}
    }
}
