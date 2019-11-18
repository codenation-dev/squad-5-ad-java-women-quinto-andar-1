package br.com.quintoandar.sakuraerrorcaptor.dto;

import java.time.LocalDateTime;

public class LogDetailsDTO {
    private Long idLog;
    private Long idOccurrence;

    private String environment;

    private String level;

    private String origin;

    private String titleLog;

    private String details;

    private Integer countEvent;

    private LocalDateTime dateLogger;

    private String systemToken;

    private UserDTO user;

    public LogDetailsDTO(Long idLog, Long idOccurrence, String level,
                         String environment, String origin, String titleLog,
                         String details, Integer countEvent, LocalDateTime dateLogger,
                         String systemToken, UserDTO user) {
        this.idLog = idLog;
        this.idOccurrence = idOccurrence;
        this.level = level;
        this.environment = environment;
        this.origin = origin;
        this.titleLog = titleLog;
        this.details = details;
        this.countEvent = countEvent;
        this.dateLogger = dateLogger;
        this.systemToken = systemToken;
        this.user = user;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public Long getIdOccurrence() {
        return idOccurrence;
    }

    public void setIdOccurrence(Long idOccurrence) {
        this.idOccurrence = idOccurrence;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTitleLog() {
        return titleLog;
    }

    public void setTitleLog(String titleLog) {
        this.titleLog = titleLog;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getCountEvent() {
        return countEvent;
    }

    public void setCountEvent(Integer countEvent) {
        this.countEvent = countEvent;
    }

    public LocalDateTime getDateLogger() {
        return dateLogger;
    }

    public void setDateLogger(LocalDateTime dateLogger) {
        this.dateLogger = dateLogger;
    }

    public String getSystemToken() {
        return systemToken;
    }

    public void setSystemToken(String systemToken) {
        this.systemToken = systemToken;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
