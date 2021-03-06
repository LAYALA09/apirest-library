package ar.com.ada.online.second.library.advice;

import ar.com.ada.online.second.library.advice.validation.RestErrorsResponse;
import ar.com.ada.online.second.library.exception.BusinessLogicException;
import ar.com.ada.online.second.library.exception.EntityError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;

@RestControllerAdvice

public class BusinessLogicExceptionHandler {

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e, NativeWebRequest req) {

        HttpStatus httpStatus = e.getHttpStatus() != null
                ? e.getHttpStatus()
                //si viene nulo
                : HttpStatus.INTERNAL_SERVER_ERROR;

        RestErrorsResponse restErrorsResponse = new RestErrorsResponse<EntityError>(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                e.getEntityErrors()
        );

        return ResponseEntity
                .status(httpStatus)
                .body(restErrorsResponse);

    }

}
