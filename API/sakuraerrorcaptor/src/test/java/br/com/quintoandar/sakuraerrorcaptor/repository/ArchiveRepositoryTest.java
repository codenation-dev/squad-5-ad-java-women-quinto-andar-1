package br.com.quintoandar.sakuraerrorcaptor.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.quintoandar.sakuraerrorcaptor.model.Archive;
import br.com.quintoandar.sakuraerrorcaptor.model.enums.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.enums.Level;
import br.com.quintoandar.sakuraerrorcaptor.model.json.ArchiveJson;
import br.com.quintoandar.sakuraerrorcaptor.model.json.LogOccurrenceJson;
import br.com.quintoandar.sakuraerrorcaptor.model.json.OccurrenceJson;
import br.com.quintoandar.sakuraerrorcaptor.model.json.TrackedSystemJson;

@ActiveProfiles("dev")
@DataJpaTest
public class ArchiveRepositoryTest {

	@Autowired
	ArchiveRepository archiveRepository;
	
	@Test
	public void saveTest() {
		ArchiveJson json = new ArchiveJson();
		OccurrenceJson oJson = new OccurrenceJson(1L,"test","save test", new ArrayList<LogOccurrenceJson>());
		oJson.setId(1L);
		List<OccurrenceJson> listOccurrence = new ArrayList<OccurrenceJson>();
		listOccurrence.add(oJson);
		
		TrackedSystemJson tSJson = new TrackedSystemJson(1L, "test system", "127.0.0.1", "0");
		List<TrackedSystemJson> listTrackedSystem = new ArrayList<TrackedSystemJson>();
		listTrackedSystem.add(tSJson);
		
		json.setEnvironment(Environment.DEV);
		json.setLevel(Level.DEBUG);
		json.setOccurrences(listOccurrence);
		json.setTrackedSystem(listTrackedSystem);
		json.addTenant(1L,"");
		System.out.println(json.toString());
		Archive archive = archiveRepository.findById(1L).get();
		//Archive archive = new Archive(1L,json);
		//archive.setArchivedIn(LocalDateTime.now());
		System.out.println(archive.getId());
		
		try{
			archiveRepository.save(archive);		
		}catch (Exception e) {
			fail("[Archive - saveTest] Não foi possível salvar"+ e.getMessage());
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
