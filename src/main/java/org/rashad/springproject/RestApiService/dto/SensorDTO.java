package org.rashad.springproject.RestApiService.dto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SensorDTO {

    @NotEmpty
    @Size(min = 2,max = 100,message = "Size of name of sensor name has to be between 2 and 100")
    private String name;

    public SensorDTO() {
    }

    public SensorDTO( String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
