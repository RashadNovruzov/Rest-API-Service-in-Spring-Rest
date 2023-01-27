package org.rashad.springproject.RestApiService.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(SensorException sensorException){
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(sensorException.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(MeasurementException measurementException){
        ExceptionResponse exceptionResponse = new ExceptionResponse(measurementException.getMessage());
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(Exception e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }

}
