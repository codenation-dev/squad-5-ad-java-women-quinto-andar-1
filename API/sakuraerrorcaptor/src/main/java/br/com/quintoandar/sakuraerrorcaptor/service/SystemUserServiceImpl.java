package br.com.quintoandar.sakuraerrorcaptor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.dto.UserChangePassDTO;
import br.com.quintoandar.sakuraerrorcaptor.dto.UserDTO;
import br.com.quintoandar.sakuraerrorcaptor.error.SystemUserNotFound;
import br.com.quintoandar.sakuraerrorcaptor.mapper.SignInMapper;
import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;
import br.com.quintoandar.sakuraerrorcaptor.repository.SystemUserRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.SystemUserService;;

@Service
public class SystemUserServiceImpl implements SystemUserService{
	@Autowired
	private SystemUserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	SignInMapper mapper = new SignInMapper();

	@Override
	public Optional<SystemUser> findById(Long id) {
        return repository.findById(id);
	}
	
	@Override
	public List<UserDTO> findByTenantId(Long id) {
		return mapper.mapUserDto(repository.findByTenantId(id));
	}

	@Override
	public SystemUser findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public SystemUser findByEmail(String email) {
		return repository.findByEmail(email).orElseThrow(()-> new SystemUserNotFound(email));
	}

	@Override
	public Optional<SystemUser> findByToken(String token) {
		return repository.findByToken(token);
	}
	
	@Override
	public boolean delete(Long id) {
		repository.findById(id).orElseThrow(()-> new SystemUserNotFound(id));
		repository.deleteById(id);	
		return true;
	}
	
	@Override
	public List<UserDTO> findAll() {
		return mapper.mapListUserDto(repository.findAll());
	}
	
	@Override
	public UserDTO findDTOById(Long id) {
		return mapper.mapUserDto(repository.findById(id).orElseThrow(()->new SystemUserNotFound(id)));
	}

	@Override
	public UserDTO alter(UserChangePassDTO userChangePassDTO) {
		SystemUser u = repository.findById(userChangePassDTO.getId()).orElseThrow(()->new SystemUserNotFound(userChangePassDTO.getId()));
		
		System.out.println(passwordEncoder.encode(userChangePassDTO.getNewPassword()));
		
		if (u.getEmail().equals(userChangePassDTO.getEmail()) &&
			passwordEncoder.matches(userChangePassDTO.getOldPassword(), u.getPassword())){
			
			u.setPassword(passwordEncoder.encode(userChangePassDTO.getNewPassword()));
			return mapper.mapUserDto(repository.save(u));
		}
		
		throw new SystemUserNotFound(userChangePassDTO.getId(), userChangePassDTO.getEmail());
	}
}
