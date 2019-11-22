package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import br.com.quintoandar.sakuraerrorcaptor.dto.SignInDTO;

public interface LoginService {
	public SignInDTO save(SignInDTO signInDTO);
}
