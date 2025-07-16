package com.alknslm.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

/**
 * Tüm exceptionların yönetileceği yer
 * @ControllerAdvice anotasyonu exception yöneteceğim class bu demek
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**Spring validaiton!dan fırlatılan hataları kullanıcıya düzgün bir metin olarak göstermek*/

    private List<String> addMapValue(List<String> list, String newValue){
        list.add(newValue);
        return list;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class) // bu classtaki hatayı yakala methoda parametre olarak geç.
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, List<String>> errosMap = new HashMap<>();

        for (ObjectError objectError: ex.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError)objectError).getField();
            if(errosMap.containsKey(fieldName)){ // hata daha önce varsa eski listeyi al
                errosMap.put(fieldName, addMapValue(errosMap.get(fieldName), objectError.getDefaultMessage()));
            }else{ // hata daha önce yoksa yeni liste oluştur öyle yaz
                errosMap.put(fieldName,addMapValue(new ArrayList<>(),objectError.getDefaultMessage()));
            }
        }
        return ResponseEntity.badRequest().body(createApiError(errosMap));
    }

    private <T> ApiError<T> createApiError(T errors){ // Herhangi bir tipte data gelebilir. 1.<T> Generic demek için. 2.<T> ApiError T tipinde data dönüyorum demek.
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);

        return apiError;
    }
}
