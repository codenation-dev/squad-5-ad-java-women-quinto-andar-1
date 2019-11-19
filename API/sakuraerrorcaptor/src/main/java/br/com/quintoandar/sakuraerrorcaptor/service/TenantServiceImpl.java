package br.com.quintoandar.sakuraerrorcaptor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.error.TenantIdAlreadyInUse;
import br.com.quintoandar.sakuraerrorcaptor.error.TenantNameAlreadyInUse;
import br.com.quintoandar.sakuraerrorcaptor.error.TenantNotFound;
import br.com.quintoandar.sakuraerrorcaptor.model.Tenant;
import br.com.quintoandar.sakuraerrorcaptor.repository.TenantRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.TenantService;

@Service
public class TenantServiceImpl implements TenantService{
	@Autowired
	TenantRepository tenantRepository;
	
	@Override
	public Tenant save(Tenant tenant) {
		if (tenantRepository.findByName(tenant.getName()).isPresent()) {
			throw new TenantNameAlreadyInUse();
		}
		try{
			return tenantRepository.save(tenant);
		}catch (Exception e) {
			throw new TenantIdAlreadyInUse();
		}
	}

	@Override
	public Tenant findById(Long id) {
		return tenantRepository.findById(id).orElseThrow(()-> new TenantNotFound());
	}

	@Override
	public List<Tenant> findAll() {
		return tenantRepository.findAll();
	}

}
