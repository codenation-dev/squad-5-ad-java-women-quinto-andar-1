package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.Optional;

import br.com.quintoandar.sakuraerrorcaptor.model.Archive;
import br.com.quintoandar.sakuraerrorcaptor.model.json.ArchiveJson;

public interface ArchiveServiceInterface {
	public Optional<Archive> findById(Long id);
	public boolean sendArchiveToLog(Long id);
	public boolean save(ArchiveJson archiveJson);
	public void deleteById(Long id);
	public void deleteByLogOccurrenceId(Long id);
}
