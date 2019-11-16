package br.com.quintoandar.sakuraerrorcaptor.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;

@Repository
public interface SystemUserRepository extends JpaRepository <SystemUser, Long>{
	
	public Optional<SystemUser> findById(Long id);	
	public SystemUser findByNome(String name);
    public List<SystemUser>findByToken (Long id);
    public List<SystemUser>findByTenatId (Long id);



}
