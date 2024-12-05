package io.github.devandref.stateless_any_api.infra.exception;

import io.github.devandref.stateless_auth_api.infra.exception.AuthenticationException;
import io.github.devandref.stateless_auth_api.infra.exception.ExceptionDetails;
import io.github.devandref.stateless_auth_api.infra.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handlerValidationException(ValidationException exception) {
        var details = new ExceptionDetails(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handlerAuthenticationException(AuthenticationException exception) {
        var details = new ExceptionDetails(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return new ResponseEntity<>(details, HttpStatus.UNAUTHORIZED);
    }

}
