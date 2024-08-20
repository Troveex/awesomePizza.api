package com.awesomepizza.api.dto;

import lombok.Getter;
import lombok.Setter;

public class ResponseDto {
    
    @Getter
    @Setter
    public  boolean status;
    
    @Getter
    @Setter
    public String message;
    
    public ResponseDto(){}
    
    public ResponseDto(String message){
        this.message = message;
        status = true;
    }
}
