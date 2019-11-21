package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.quintoandar.sakuraerrorcaptor.dto.UserDTO;
import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;

public interface SystemUserService {

	public Optional<SystemUser> findById(Long id);		
	public UserDTO alter(SystemUser systemUser);
	public boolean delete(Long id);
    public List<UserDTO> findByTenantId (Long id);
    public SystemUser findByName (String name);
    public SystemUser findByEmail(String email);
    public Optional<SystemUser>findByToken (String id);
    public UserDTO findDTOById(Long id);
	public List<UserDTO> findAll();

}
