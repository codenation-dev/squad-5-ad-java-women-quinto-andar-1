package br.com.quintoandar.sakuraerrorcaptor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;
import br.com.quintoandar.sakuraerrorcaptor.repository.SystemUserRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.SystemUserService;;

@Service
public class SystemUserServiceImpl implements SystemUserService{

	private final SystemUserRepository systemUser;

	@Autowired
	SystemUserServiceImpl(SystemUserRepository repository) {
		this.systemUser = repository;
	}

	@Override
	public Optional<SystemUser> buscar(Long id) {
		return systemUser.findById(id);
	}

	@Override
	public Iterable<SystemUser> pesquisar() {
		return systemUser.findAll();
	}

	@Override
	public SystemUser toSave(SystemUser systemUser) {
		return this.systemUser.save(systemUser);
	}

	@Override
	public void delete(Long id) {
		systemUser.deleteById(id);
		
	}

	@Override
	public SystemUser alterar(SystemUser systemUser) {
		return this.systemUser.save(systemUser);
	}
	

	



}
