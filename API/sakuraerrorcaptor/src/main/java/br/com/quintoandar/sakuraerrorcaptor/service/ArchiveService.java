package br.com.quintoandar.sakuraerrorcaptor.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.exception.ArchiveNotFoundException;
import br.com.quintoandar.sakuraerrorcaptor.model.Archive;
import br.com.quintoandar.sakuraerrorcaptor.model.json.ArchiveJson;
import br.com.quintoandar.sakuraerrorcaptor.repository.ArchiveRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.ArchiveServiceInterface;

@Service
public class ArchiveService implements ArchiveServiceInterface{

	@Autowired
	ArchiveRepository archiveRepository;
	
	@Override
	public Optional<Archive> findById(Long id) {
		return archiveRepository.findById(id);
	}
	
	@Override
	public boolean sendArchiveToLog(Long id) {
		if (archiveRepository.findById(id).isPresent()) {
			Archive archive = archiveRepository.findById(id).get();
			
			saveLog(archive.getArchive());
			return true;
		} else {
			return false;
		}		
	}
	
	private void saveLog(ArchiveJson archiveJson) {
		
	}

	@Override
	public boolean save(ArchiveJson archiveJson) {
		Archive archive = new Archive();
		archive.setArchive(archiveJson);
		archive.setArchivedIn(LocalDateTime.now());
		
		try {
			archiveRepository.save(archive);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}

	@Override
	public void deleteById(Long id) {
		archiveRepository.deleteById(id);		
	}

	@Override
	public void deleteByLogOccurrenceId(Long id) {
		List<Archive> archives = archiveRepository.findByLogOccurenceId(id);
		
		for (Archive archive : archives) {
			deleteById(archive.getId());
		}
		
	}

}
