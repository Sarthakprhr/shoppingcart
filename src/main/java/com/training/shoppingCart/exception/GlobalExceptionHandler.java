package com.training.shoppingCart.exception;





import com.training.shoppingCart.DTO.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleUserNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse apiresponse = new ApiResponse(message,false);

        return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.NOT_FOUND);
    }

}
