package com.springboot.OMS_POC.Common;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GenericResponse {
    Object data;
    Integer status;

    public GenericResponse() {
        this.data=data;
        this.status=HttpStatus.OK.value();
    }
}
