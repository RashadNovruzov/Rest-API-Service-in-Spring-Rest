package org.rashad.springproject.RestApiService.dto;

public class RainyDaysCountDTO {
    private int rainyDaysCount;

    public RainyDaysCountDTO() {
    }

    public RainyDaysCountDTO(int rainyDaysCount) {
        this.rainyDaysCount = rainyDaysCount;
    }

    public int getRainyDaysCount() {
        return rainyDaysCount;
    }

    public void setRainyDaysCount(int rainyDaysCount) {
        this.rainyDaysCount = rainyDaysCount;
    }
}
