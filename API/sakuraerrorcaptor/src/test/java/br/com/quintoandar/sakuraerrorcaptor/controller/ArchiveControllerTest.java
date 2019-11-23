package br.com.quintoandar.sakuraerrorcaptor.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.quintoandar.sakuraerrorcaptor.model.Archive;

@ActiveProfiles("test")
@DataJpaTest
public class ArchiveControllerTest {

	@Test
	public void testFindById() {
		/*Archive a = archiveService.findById(id).orElse(new Archive());
		Archive b = new Archive();
		b.setArchive(a.getArchive());
		archiveService.save(b.getArchive());
		return a;
		*/
	}

}
