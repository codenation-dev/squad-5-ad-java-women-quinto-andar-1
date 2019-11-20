package br.com.quintoandar.sakuraerrorcaptor.mapper;

import br.com.quintoandar.sakuraerrorcaptor.dto.LogDetailsDTO;
import br.com.quintoandar.sakuraerrorcaptor.dto.LogOccurrenceDTO;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

public class LogOccurrenceMapper {

    public LogDetailsDTO map(LogOccurrence logOccurrence){
        LogDetailsDTO logOccurrenceDTO =  new LogDetailsDTO(
                logOccurrence.getLog().getId(),
                logOccurrence.getOccurrence().getId(),
                logOccurrence.getLog().getLevel().toString(),
                logOccurrence.getLog().getEnvironment().toString(),
                logOccurrence.getLog().getTrackedSystem().getLocation(),
                logOccurrence.getOccurrence().getTitle(),
                logOccurrence.getOccurrence().getDetail(),
                //TODO: Verificar count
                0,
                LocalDateTime.now(),
                logOccurrence.getLog().getTrackedSystem().getToken(),
                //TODO: Verificar origin do user
                null
        );

        return logOccurrenceDTO;
    };

    public List<LogDetailsDTO> map(List<LogOccurrence> logs){

        List<LogDetailsDTO> logsDTO = new ArrayList<>();

        for(LogOccurrence item : logs){
            LogDetailsDTO obj = new LogDetailsDTO(
                    item.getLog().getId(),
                    item.getOccurrence().getId(),
                    item.getLog().getLevel().toString(),
                    item.getLog().getEnvironment().toString(),
                    item.getLog().getTrackedSystem().getLocation(),
                    item.getOccurrence().getTitle(),
                    item.getOccurrence().getDetail(),
                    //TODO: Verificar count
                    0,
                    LocalDateTime.now(),
                    item.getLog().getTrackedSystem().getToken(),
                    //TODO: Verificar origin do user
                    null
            );

            logsDTO.add(obj);
        }

        return logsDTO;
    };
    
    public List<LogOccurrenceDTO> mapTupleToDTO(List<Tuple> tuples){
    	List<LogOccurrenceDTO> logOccurrencesDto = new ArrayList<LogOccurrenceDTO>();
    	
    	for (Tuple t: tuples) {
			logOccurrencesDto.add(mapTupleToDTO(t));
		}
    	return logOccurrencesDto;
    }
    
    public LogOccurrenceDTO mapTupleToDTO(Tuple tuple){
    	LogOccurrenceDTO logOccurrenceDto = new LogOccurrenceDTO(
    			Long.parseLong(tuple.get("event").toString()), 
    			tuple.get("level").toString(), 
    			tuple.get("environment").toString(), 
    			tuple.get("title").toString(), 
    			tuple.get("detail").toString(), 
    			Long.parseLong(tuple.get("log_id").toString()), 
    			Long.parseLong(tuple.get("occurrence_id").toString()), 
    			tuple.get("location").toString());
    	
    	return logOccurrenceDto;
    }
}
