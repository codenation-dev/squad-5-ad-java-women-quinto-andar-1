package br.com.quintoandar.sakuraerrorcaptor.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;

@Service
public class SystemUserServiceImpl implements SystemUserService{

	
	
	@Override
	public Optional<SystemUser> buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<SystemUser> pesquisar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemUser salvar(SystemUser systemUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SystemUser alterar(SystemUser systemUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
