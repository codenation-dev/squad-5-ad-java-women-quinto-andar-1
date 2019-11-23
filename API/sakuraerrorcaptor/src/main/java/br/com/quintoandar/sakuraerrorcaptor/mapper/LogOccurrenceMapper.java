package br.com.quintoandar.sakuraerrorcaptor.mapper;

import br.com.quintoandar.sakuraerrorcaptor.dto.LogDetailsDTO;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;
import br.com.quintoandar.sakuraerrorcaptor.util.LocalDateTimeConverter;

import java.sql.Timestamp;
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
				0L,
				LocalDateTime.now(),
				logOccurrence.getLog().getTrackedSystem().getToken()
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
					0L,
					LocalDateTime.now(),
					item.getLog().getTrackedSystem().getToken()
					);

			logsDTO.add(obj);
		}

		return logsDTO;
	};

	public List<LogDetailsDTO> mapTupleToDTO(List<Tuple> tuples){
		List<LogDetailsDTO> logOccurrencesDto = new ArrayList<LogDetailsDTO>();

		for (Tuple t: tuples) {
			logOccurrencesDto.add(mapTupleToDTO(t));
		}
		return logOccurrencesDto;
	}

	public LogDetailsDTO mapTupleToDTO(Tuple tuple){

		LocalDateTimeConverter dateConverter = new LocalDateTimeConverter();
		LocalDateTime maxDate = dateConverter.convertToEntityAttribute((Timestamp)tuple.get("occurred_in"));

		LogDetailsDTO logOccurrenceDto = new LogDetailsDTO(
				Long.parseLong(tuple.get("log_id").toString()), 
				Long.parseLong(tuple.get("occurrence_id").toString()),
				tuple.get("level").toString(), 
				tuple.get("environment").toString(),
				tuple.get("location").toString(),
				tuple.get("title").toString(), 
				tuple.get("detail").toString(),
				Long.parseLong(tuple.get("event").toString()),
				maxDate,
				tuple.get("token").toString());

		return logOccurrenceDto;
	}
}
