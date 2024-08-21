package com.awesomepizza.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class OrderUpdateRequest {
    
    @Getter
    @Setter
    public UUID code;
    
    @Getter
    @Setter
    public String status;
}
