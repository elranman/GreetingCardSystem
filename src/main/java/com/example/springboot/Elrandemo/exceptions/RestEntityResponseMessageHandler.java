package com.example.springboot.Elrandemo.exceptions;

import com.example.springboot.Elrandemo.constants.Constants;
import com.example.springboot.Elrandemo.domain.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class RestEntityResponseMessageHandler
                extends ResponseEntityExceptionHandler {

      @ExceptionHandler(GreetCardFileFormatNotSupportedException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(
            GreetCardFileFormatNotSupportedException exception,
            WebRequest request){

          ErrorMessage message = new ErrorMessage(
                  HttpStatus.INTERNAL_SERVER_ERROR,
                  Constants.FILE_TYPE_NOT_SUPPORTED_MSG);

          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(message);
      }
}
