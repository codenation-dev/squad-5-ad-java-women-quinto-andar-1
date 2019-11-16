package br.com.quintoandar.sakuraerrorcaptor.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;
import br.com.quintoandar.sakuraerrorcaptor.repository.SystemUserRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.SystemUserService;;

@Service
public class SystemUserServiceImpl implements SystemUserService{

	private final SystemUserRepository repository;

	@Autowired
	SystemUserServiceImpl(SystemUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<SystemUser> findById(Long id) {
        return repository.findById(id);

	}

	@Override
	public SystemUser save(SystemUser systemUser) {
        return repository.save(systemUser);

	}

	@Override
	public List<SystemUser> findByTenatId(Long id) {
		return repository.findByTenatId(id);
	}


	@Override
	public SystemUser findByName(String name) {
		return repository.findByNome(name);
	}

	@Override
	public List<SystemUser> findByToken(Long id) {
		return repository.findByToken(id);
	}



	



}
