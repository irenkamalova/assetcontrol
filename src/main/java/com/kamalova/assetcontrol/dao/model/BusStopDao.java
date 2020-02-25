package com.kamalova.assetcontrol.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "bus_stops")
@ApiModel(description = "bus_stops")
public class BusStopDao {
    @Id
    @Column(name = "bus_id")
    @JsonProperty("busStopId")
    private String busStopId;

    @Column(name = "name")
    @JsonProperty("busStopName")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "listBusStops",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<RouteDao> routeList;

    @JsonIgnore
    @OneToMany(mappedBy = "busStop")
    private Set<ReservationDao> reservations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStopDao that = (BusStopDao) o;
        return Objects.equals(busStopId, that.busStopId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(busStopId);
    }
}
