package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.Optional;

import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;

public interface SystemUserService {

	public Optional<SystemUser> buscar(Long id);
	public Iterable<SystemUser> pesquisar();
	public SystemUser toSave(SystemUser systemUser);
	public void delete(Long id);
	public SystemUser alterar(SystemUser systemUser);
}
