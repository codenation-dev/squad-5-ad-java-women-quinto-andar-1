package br.com.quintoandar.sakuraerrorcaptor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.dto.SignInDTO;
import br.com.quintoandar.sakuraerrorcaptor.error.SystemUserAlreadyExists;
import br.com.quintoandar.sakuraerrorcaptor.mapper.SignInMapper;
import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;
import br.com.quintoandar.sakuraerrorcaptor.repository.SystemUserRepository;
import br.com.quintoandar.sakuraerrorcaptor.repository.TenantRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	SystemUserRepository systemUserRepository;
	
	@Autowired
	TenantRepository tenantRepository;
	SignInMapper mapper = new SignInMapper();
	
	@Override
	public SignInDTO save(SignInDTO signInDTO) {
		if (isValidUser(signInDTO)) {
			SystemUser systemUser = mapper.toUser(signInDTO);
			return mapper.map(systemUserRepository.save(systemUser));
		} else {
			throw new SystemUserAlreadyExists(signInDTO.getEmail());
		}
	}
	
	private boolean isValidUser(SignInDTO signInDTO) {
		if (signInDTO.getTenant() == null) {
			signInDTO.setTenant(tenantRepository.findById(1L).get());
		}
		if (systemUserRepository.findByEmail(signInDTO.getEmail()).isPresent()) {
			return false;
		}
		return true;
	}
}
