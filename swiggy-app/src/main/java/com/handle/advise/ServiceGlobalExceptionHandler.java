package com.handle.advise;

import lombok.extern.slf4j.Slf4j;
import org.example.common.advice.SwiggyServiceGlobalExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ServiceGlobalExceptionHandler extends SwiggyServiceGlobalExceptionHandler {

  /*  @ExceptionHandler(SwiggyServiceException.class)
    public ResponseEntity<?> handleSwiggyServiceException(SwiggyServiceException ex) throws JsonProcessingException {
        log.error("SwiggyServiceGlobalExceptionHandler::handleSwiggyServiceException exception caught {}",ex.getMessage());
        CustomErrorResponse errorResponse = new ObjectMapper().readValue(ex.getMessage(), CustomErrorResponse.class);
        return ResponseEntity.internalServerError().body(errorResponse);
    }
*/
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handleGenericException(Exception ex){
//        CustomErrorResponse errorResponse= CustomErrorResponse.builder()
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .errorCode(GlobalErrorCode.GENERIC_ERROR)
//                .errorMessage(ex.getMessage())
//                .build()  ;
//        log.error("RestaurantServiceGlobalExceptionHandler::handleGenericException exception caught {}",ex.getMessage());
//        return ResponseEntity.internalServerError().body(errorResponse);
//    }
}
