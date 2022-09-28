package com.springboot.OMS_POC.Common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class GenericResponse<T> {
    T data;
    Integer status;

    public GenericResponse() {
        this.status = HttpStatus.OK.value();
    }
}
