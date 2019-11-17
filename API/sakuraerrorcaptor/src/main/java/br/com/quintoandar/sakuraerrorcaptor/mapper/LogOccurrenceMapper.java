package br.com.quintoandar.sakuraerrorcaptor.mapper;

import br.com.quintoandar.sakuraerrorcaptor.dto.LogDTO;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogOccurrenceMapper {

    public LogDTO map(LogOccurrence logOccurrence){
        LogDTO logOccurrenceDTO =  new LogDTO(
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

    public List<LogDTO> map(List<LogOccurrence> logs){

        List<LogDTO> logsDTO = new ArrayList<>();

        for(LogOccurrence item : logs){
            LogDTO obj = new LogDTO(
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
}
