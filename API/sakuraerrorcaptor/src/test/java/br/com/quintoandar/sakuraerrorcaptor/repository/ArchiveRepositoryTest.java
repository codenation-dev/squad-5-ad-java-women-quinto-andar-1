package br.com.quintoandar.sakuraerrorcaptor.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.quintoandar.sakuraerrorcaptor.model.Archive;
import br.com.quintoandar.sakuraerrorcaptor.model.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.json.ArchiveJson;

@ActiveProfiles("dev")
@DataJpaTest
public class ArchiveRepositoryTest {

	@Autowired
	ArchiveRepository archiveRepository;
	
	@Test
	public void saveTest() {
		ArchiveJson json = new ArchiveJson();
		json.setTenant("1");
		json.setTenantId(1L);
		json.setEnvironment(Environment.DEV);
		
		Archive archive = new Archive(1L,json);
		
		try{
			archiveRepository.save(archive);		
		}catch (Exception e) {
			fail("[Archive - saveTest] Não foi possível salvar"+ e.getCause());
		}
	}
	
	@Test
	public void findByIdTest() {
		Archive archive = new Archive(1L,new ArchiveJson());
		archiveRepository.save(archive);		
		
		Archive archiveResult = archiveRepository.findById(1L).get();
		assertEquals((Long)1L, archiveResult.getId());
	}
	
	@Test
	public void findByTrackedSystemTest() {

	}
	
	@Test
	public void deleteByIdTest() {
		Archive archive = new Archive(1L,new ArchiveJson());
		archiveRepository.save(archive);
		try{
			archiveRepository.deleteById(1L);
			assertTrue(true);
		}catch (Exception e) {
			fail("[Archive - deleteByIdTest] Não foi possível apagar o registro");
		}
	}

}
