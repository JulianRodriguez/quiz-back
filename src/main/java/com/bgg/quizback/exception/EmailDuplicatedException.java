package com.bgg.quizback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Email duplicate")
public class EmailDuplicatedException extends Exception{

}
