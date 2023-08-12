package kz.zhantekov.springcourse.tz1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BadRequestException extends RuntimeException {

    private String message;
    private String error;
}
