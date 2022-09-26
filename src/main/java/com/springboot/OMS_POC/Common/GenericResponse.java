package com.springboot.OMS_POC.Common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
public class GenericResponse
{
    Object data;
    Integer status;

    public GenericResponse()
    {
        this.data=data;
        this.status=HttpStatus.OK.value();
    }
}
