package br.com.quintoandar.sakuraerrorcaptor.dto;

public class UserChangePassDTO {
	private Long id;
	private String email;
	private String oldPassword;
	private String newPassword;
	
	public UserChangePassDTO() {
		
	}
	public UserChangePassDTO(Long id, String email, String oldPassword, String newPassword) {
		super();
		this.id = id;
		this.email = email;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
