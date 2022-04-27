package com.zageno.urlshortner.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/** Controller advice class to handle all global exceptions
 * @author Rishi Pathania
 * @version 1.0
 */
@ControllerAdvice
public class ControllerAd {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {
        Map<String, Object> errorBody = new LinkedHashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("message", e.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(LinkNotSavedException.class)
    public ResponseEntity<Object> handleLinkNotSavedException(LinkNotSavedException e) {
        Map<String, Object> errorBody = new LinkedHashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("message", e.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LinkExpiredException.class)
    public ResponseEntity<Object> handleLinkExpiredException(LinkExpiredException e) {
        Map<String, Object> errorBody = new LinkedHashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("message", e.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UrlInvalidException.class)
    public ResponseEntity<Object> handleUrlEmptyException(UrlInvalidException e) {
        Map<String, Object> errorBody = new LinkedHashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("message", e.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }


}
