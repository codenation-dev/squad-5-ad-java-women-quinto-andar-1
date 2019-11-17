package br.com.quintoandar.sakuraerrorcaptor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quintoandar.sakuraerrorcaptor.model.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long>{

}
