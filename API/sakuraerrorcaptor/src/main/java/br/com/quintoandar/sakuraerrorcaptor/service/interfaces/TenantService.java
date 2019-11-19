package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.List;

import br.com.quintoandar.sakuraerrorcaptor.model.Tenant;

public interface TenantService {
	public Tenant save(Tenant tenant);
	public Tenant findById(Long id);
	public List<Tenant> findAll();
}
