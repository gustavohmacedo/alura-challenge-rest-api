package br.com.alura.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FormErrorDto {
    private String field;
    private String errorMessage;

}
