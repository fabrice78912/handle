package org.example.common.advice;


import lombok.extern.slf4j.Slf4j;
import org.example.common.dto.CustomErrorResponse;
import org.example.common.dto.GlobalErrorCode;
import org.example.common.exception.OrderNotFoundException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//@ComponentScan(basePackages="org.example.common.advice")
@Slf4j
public class RestaurantServiceGlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<?> handleOrderNotFoundException(OrderNotFoundException ex){
        CustomErrorResponse errorResponse= CustomErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorCode(GlobalErrorCode.ERROR_ORDER_NOT_FOUND)
                .errorMessage(ex.getMessage())
                .build()  ;
        log.error("RestaurantServiceGlobalExceptionHandler::handleOrderNotFoundException exception caught {}",ex.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }

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
