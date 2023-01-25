package org.rashad.springproject.RestApiService.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<SensorExceptionResponse> handleException(SensorException sensorException){
        SensorExceptionResponse sensorExceptionResponse =
                new SensorExceptionResponse(sensorException.getMessage());
        return new ResponseEntity<>(sensorExceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
