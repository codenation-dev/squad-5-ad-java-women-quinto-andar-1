package br.com.quintoandar.sakuraerrorcaptor.service;

import java.util.Optional;

import javax.validation.Valid;

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
		// TODO Auto-generated method stub
		return null;
	}



	



}
