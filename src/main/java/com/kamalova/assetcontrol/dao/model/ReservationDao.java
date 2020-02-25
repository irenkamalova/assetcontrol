package com.kamalova.assetcontrol.dao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
@ApiModel(description = "reservation")
public class ReservationDao {
    @Id
    @Column(name = "reservation_id", unique = true)
    @JsonProperty("reservationId")
    private String reservationId;

    @JsonProperty("route")
    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private RouteDao route;

    @Column(name = "reservation_date")
    @JsonProperty("date")
    private String date;

    @Column(name = "child")
    @JsonProperty("childName")
    private String childName;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    @JsonProperty("busStop")
    private BusStopDao busStop;
}
