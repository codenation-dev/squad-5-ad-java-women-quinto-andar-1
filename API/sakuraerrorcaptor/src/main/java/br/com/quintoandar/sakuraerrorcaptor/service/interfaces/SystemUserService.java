package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.Optional;

import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;

public interface SystemUserService {

	public Optional<SystemUser> findById(Long id);	
    public SystemUser save (SystemUser systemUser);
}
