package Dusigi.bookworm.global.error;

import Dusigi.bookworm.global.error.GlobalException;
import Dusigi.bookworm.global.error.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@EnableWebMvc
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    private ResponseEntity<ErrorResponse> globalException(GlobalException e) {
        log.warn("Expected Exception : {} ", e.getMessage());
        log.trace("Expected Exception Details : ", e);
        return new ResponseEntity<>(ErrorResponse.of(e), HttpStatusCode.valueOf(e.getHttpStatus().value()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> validateException(MethodArgumentNotValidException e) {
        log.warn("Validation Failed : {}", e.getMessage());
        log.trace("Validation Failed Details : ", e);
        return new ResponseEntity<>(new ErrorResponse(methodArgumentNotValidExceptionToJson(e)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> unExpectedException(RuntimeException e) {
        log.error("UnExpectedException Occur : ", e);
        return new ResponseEntity<>(new ErrorResponse("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> noHandlerFoundException(NoHandlerFoundException e) {
        log.warn("Not Found Endpoint : {}", e.getMessage());
        log.trace("Not Found Endpoint Details : ", e);
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.getReasonPhrase()), HttpStatus.FORBIDDEN);
    }

    private static String methodArgumentNotValidExceptionToJson(MethodArgumentNotValidException e) {
        Map<String, Object> globalResults = new HashMap<>();
        Map<String, String> fieldResults = new HashMap<>();

        e.getBindingResult().getGlobalErrors().forEach(error -> globalResults.put(e.getBindingResult().getObjectName(), error.getDefaultMessage()));
        e.getBindingResult().getFieldErrors().forEach(error -> fieldResults.put(error.getField(), error.getDefaultMessage()));
        globalResults.put(e.getBindingResult().getObjectName(), fieldResults);

        return new JSONObject(globalResults).toString().replace("\"", "'");
    }
}
