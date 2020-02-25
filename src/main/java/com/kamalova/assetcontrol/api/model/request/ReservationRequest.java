package com.kamalova.assetcontrol.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequest {
    @JsonProperty
    String childName;
    @JsonProperty
    String busStop;
}
