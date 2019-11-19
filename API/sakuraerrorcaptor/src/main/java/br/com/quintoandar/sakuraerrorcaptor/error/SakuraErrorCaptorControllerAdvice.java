package br.com.quintoandar.sakuraerrorcaptor.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class SakuraErrorCaptorControllerAdvice {

    @ExceptionHandler(OccurrenceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleOccurrenceNotFoundException(OccurrenceNotFound ex) {
        return ex.getMessage();
    }
    
    @ExceptionHandler(TenantNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleTenantNotFoundException(TenantNotFound ex) {
        return ex.getMessage();
    }
    
    @ExceptionHandler(SystemUserNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleSystemUserNotFoundException(SystemUserNotFound ex) {
        return ex.getMessage();
    }
    
    @ExceptionHandler(TenantIdAlreadyInUse.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleTenantIdAlreadyInUseException(TenantIdAlreadyInUse ex) {
        return ex.getMessage();
    }
    
    @ExceptionHandler(TenantNameAlreadyInUse.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleTenantNameAlreadyInUseException(TenantNameAlreadyInUse ex) {
        return ex.getMessage();
    }

}
