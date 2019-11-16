package br.com.quintoandar.sakuraerrorcaptor.service;

import java.util.Optional;

import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;

public interface SystemUserService {

	public Optional<SystemUser> buscar(Long id);
	public Iterable<SystemUser> pesquisar();
	public SystemUser salvar(SystemUser systemUser);
	public void deletar(Long id);
	public SystemUser alterar(SystemUser systemUser);
}
