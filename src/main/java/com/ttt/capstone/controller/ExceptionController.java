package com.ttt.capstone.controller;

import com.ttt.capstone.exception.InvalidRequest;
import com.ttt.capstone.exception.TttException;
import com.ttt.capstone.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse invalidRequestHandler(MethodArgumentNotValidException e) {

//        ErrorResponse response = new ErrorResponse("400","잘못된 요청입니다.");
        ErrorResponse response = ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.toString())
                .message("잘못된 요청입니다.")
                .build();

        for (FieldError fieldError : e.getFieldErrors()) {
            response.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return response;
    }

    @ResponseBody
    @ExceptionHandler(TttException.class)
    public ResponseEntity<ErrorResponse> tttException(TttException e){
        int statusCode = e.getStatusCode();

        ErrorResponse body = ErrorResponse.builder()
                .code(String.valueOf(statusCode))
                .message(e.getMessage())
                .validaion(e.getValidaion())
                .build();

        // 응답 json validation -> title : 제목에 바보를 포함할 수 없습니다. 작업시작

        ResponseEntity<ErrorResponse> response = ResponseEntity.status(statusCode)
                .body(body);
        return response;
    }
}

