package br.com.quintoandar.sakuraerrorcaptor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.dto.SignInDTO;
import br.com.quintoandar.sakuraerrorcaptor.dto.UserDTO;
import br.com.quintoandar.sakuraerrorcaptor.error.SystemUserNotFound;
import br.com.quintoandar.sakuraerrorcaptor.mapper.SignInMapper;
import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;
import br.com.quintoandar.sakuraerrorcaptor.repository.SystemUserRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	SystemUserRepository systemUserRepository;
	
	@Override
	public SignInDTO save(SignInDTO signInDTO) {
		SignInMapper mapper = new SignInMapper();
		SystemUser systemUser = mapper.toUser(signInDTO);
		return mapper.map(systemUserRepository.save(systemUser));
	}

	@Override
	public UserDTO findById(Long id) {
		SignInMapper mapper = new SignInMapper();
		return mapper.mapUserDto(systemUserRepository.findById(id).orElseThrow(()->new SystemUserNotFound(id)));
	}

	@Override
	public List<UserDTO> findAll() {
		SignInMapper mapper = new SignInMapper();
		return mapper.mapListUserDto(systemUserRepository.findAll());
	}
}
