package br.com.quintoandar.sakuraerrorcaptor.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;

@Repository
public interface SystemUserRepository extends JpaRepository <SystemUser, Long>{
	
	public SystemUser findByNome(String nome);


}
