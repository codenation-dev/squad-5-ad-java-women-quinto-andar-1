package br.com.quintoandar.sakuraerrorcaptor.dto;

public class UserDTO {
    public Long id;
    public String token;
    public String name;
    
	public UserDTO(Long id, String token, String name) {
		super();
		this.id = id;
		this.token = token;
		this.name = name;
	}
	
	public UserDTO() {		
	}    
}
