package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.quintoandar.sakuraerrorcaptor.model.Archive;
import br.com.quintoandar.sakuraerrorcaptor.model.json.ArchiveJson;

public interface ArchiveService {
	public Optional<Archive> findById(Long id);
	public List<Archive> findAll();
	public boolean sendArchiveToLog(Long archiveId);
	public boolean sendLogOccurrenceToArchive(Long logOccurrenceId);
	public boolean save(ArchiveJson archiveJson);
	public boolean deleteById(Long id);
}
