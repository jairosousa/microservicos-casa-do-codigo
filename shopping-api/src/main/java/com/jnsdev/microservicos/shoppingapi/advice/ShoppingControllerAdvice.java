package com.jnsdev.microservicos.shoppingapi.advice;

import com.jnsdev.microservicos.shoppingclient.dto.ErrorDTO;
import com.jnsdev.microservicos.shoppingclient.exception.CategoryNotFoundException;
import com.jnsdev.microservicos.shoppingclient.exception.ProductNotFoundException;
import com.jnsdev.microservicos.shoppingclient.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 12/10/2021 - 10:34
 */
@ControllerAdvice(basePackages = "com.jnsdev.microservicos.shoppingapi.controller")
public class ShoppingControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleProductNotFound(
            ProductNotFoundException productNotFoundException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Produto não encontrado.");
        errorDTO.setTimestamp(new Date());
        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFound(
            UserNotFoundException userNotFoundException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Usuário não encontrado.");
        errorDTO.setTimestamp(new Date());
        return errorDTO;
    }

}
