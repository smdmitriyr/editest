package com.ediweb.test.core;

import com.ediweb.test.model.Route;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "routeService")
public class RoutesService {

    private List<Route> routes = new ArrayList<>();
    private int routeAllocation = 1;

    private int allocateRouteId() {
        return routeAllocation++;
    }

    public boolean deleteRoute(Integer id) {
        return routes.removeIf(r -> r.getId().equals(id));
    }

    public Integer addOrUpdateRoute(Route route) {
        if (route.getId() == null) {
            route.setId(allocateRouteId());
            routes.add(route);
            return route.getId();
        } else {
            Optional<Route> optional = routes.stream().filter(r -> r.getId().equals(route.getId())).findFirst();
            if (optional.isPresent()) {
                Route found = optional.get();
                found.refill(route);
                return route.getId();
            } else {
                return null;
            }
        }
    }

    public List<Route> getRoutes(Integer agentId) {
        if (agentId == null) {
            return routes;
        } else {
            return routes.stream().filter(r -> r.getAgentId().equals(agentId)).collect(Collectors.toList());
        }
    }

}
