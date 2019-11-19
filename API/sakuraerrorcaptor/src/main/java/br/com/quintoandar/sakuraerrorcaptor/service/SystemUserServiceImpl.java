package br.com.quintoandar.sakuraerrorcaptor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.error.TenantNotFound;
import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;
import br.com.quintoandar.sakuraerrorcaptor.model.Tenant;
import br.com.quintoandar.sakuraerrorcaptor.repository.SystemUserRepository;
import br.com.quintoandar.sakuraerrorcaptor.repository.TenantRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.SystemUserService;;

@Service
public class SystemUserServiceImpl implements SystemUserService{
	@Autowired
	private SystemUserRepository repository;

	@Autowired
	private TenantRepository tenantRepository;

	@Override
	public Optional<SystemUser> findById(Long id) {
        return repository.findById(id);

	}

	@Override
	public SystemUser save(SystemUser systemUser) {
		if (systemUser.getTenant() == null ||
			!tenantRepository.findByIdAndName(systemUser.getTenant().getId(),
					                          systemUser.getTenant().getName()).isPresent()	) {
			throw new TenantNotFound();
		}
		systemUser.setActive(true);
		systemUser.setAdmin(false);
		systemUser.setTenant(tenantRepository.findById(systemUser.getTenant().getId()).orElseThrow(()-> new TenantNotFound()));
        
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
	public SystemUser findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public Optional<SystemUser> findByToken(String token) {
		return repository.findByToken(token);
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
