package br.com.lgrapplications.aula.aulaspring.aulaspring.base.exceptions.handlers;

import br.com.lgrapplications.aula.aulaspring.aulaspring.base.exceptions.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity handleBusinessException(HttpServletRequest request, BusinessException ex){
        log.error("URL: " + request.getMethod()
                + " - " + request.getRequestURL()
                + " Erros: " + ex.getMessage(),ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(HttpServletRequest request , ConstraintViolationException ex){
        log.error("URL: " + request.getMethod()
                + " - " + request.getRequestURL()
                + " Erros: " + ex.getMessage(),ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
