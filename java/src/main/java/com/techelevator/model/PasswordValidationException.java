package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.I_AM_A_TEAPOT, reason = "Password validation failed.")
public class PasswordValidationException extends Exception{
public PasswordValidationException(){
super("Password must have: 8 Characters, 1 Number, 1 Uppercase, 1 Lowercase. Please try again ");
}
}
