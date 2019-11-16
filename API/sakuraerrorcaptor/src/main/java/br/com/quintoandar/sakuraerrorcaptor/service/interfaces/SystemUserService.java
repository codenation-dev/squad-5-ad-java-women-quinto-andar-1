package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;

public interface SystemUserService {

	public Optional<SystemUser> findById(Long id);	
    public SystemUser save (SystemUser systemUser);
	public Iterable<SystemUser> pesquisar();
	public void deletar(Long id);
	public SystemUser alterar(SystemUser systemUser);


    public List<SystemUser>findByTenantId (Long id);
    public SystemUser findByName (String name);
    public Optional<SystemUser>findByToken (String id);

}
