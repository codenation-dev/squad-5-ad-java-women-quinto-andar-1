package br.com.quintoandar.sakuraerrorcaptor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

import br.com.quintoandar.sakuraerrorcaptor.model.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long>{
	public Optional<Tenant> findByIdAndName(Long id, String name);
	public Optional<Tenant> findByName(String name);
}
