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
	public List<SystemUser> findByTenantId(Long id) {
		return repository.findByTenantId(id);
	}


	@Override
	public SystemUser findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Optional<SystemUser> findByToken(String id) {
		return repository.findByToken(id);
	}

	@Override
	public Iterable<SystemUser> pesquisar() {
		return repository.findAll();
	}

	@Override
	public void deletar(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public SystemUser alterar(SystemUser systemUser) {
		return repository.save(systemUser);
	}

	


	



	



}
