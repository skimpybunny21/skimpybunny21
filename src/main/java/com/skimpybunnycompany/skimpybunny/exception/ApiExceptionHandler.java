package com.skimpybunnycompany.skimpybunny.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = { ApiRequestException.class })
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e, WebRequest webRequest) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(e.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, badRequest);
    }
}
