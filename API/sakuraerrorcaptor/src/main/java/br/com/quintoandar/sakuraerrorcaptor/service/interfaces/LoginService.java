package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.List;

import br.com.quintoandar.sakuraerrorcaptor.dto.SignInDTO;
import br.com.quintoandar.sakuraerrorcaptor.dto.UserDTO;

public interface LoginService {
	public SignInDTO save(SignInDTO signInDTO);
}
