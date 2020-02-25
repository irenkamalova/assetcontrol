package com.kamalova.assetcontrol.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Table(name = "routes")
@ApiModel(description = "routes")
public class RouteDao {
    @Id
    @Column(name = "route_id")
    @JsonProperty("routeId")
    private String routeId;

    @Column(name = "name")
    @JsonProperty("routeName")
    private String routeName;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "routes_stops",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_id"))
    private Set<BusStopDao> listBusStops;

    @JsonIgnore
    @OneToMany(mappedBy = "route")
    private Set<ReservationDao> reservations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDao routeDao = (RouteDao) o;
        return Objects.equals(routeId, routeDao.routeId) &&
                Objects.equals(routeName, routeDao.routeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId);
    }
}
