package com.ediweb.test;

import com.ediweb.test.core.RoutesService;
import com.ediweb.test.model.Agent;
import com.ediweb.test.model.AnswerModel;
import com.ediweb.test.model.Route;
import com.ediweb.test.model.TradePoint;
import com.ediweb.test.utils.DataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/client-api")
public class TestApplication {

	@Configuration
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		}
	}

	public static final String METHOD_GREETING = "greeting";
	public static final String METHOD_AGENTS = "agents";
	public static final String METHOD_TRADE_POINTS = "trade-points";
	public static final String METHOD_ROUTES = "routes";

	@Autowired
	@Qualifier("routeService")
	private RoutesService routesService;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@RequestMapping(METHOD_GREETING)
	public Map<String,Object> home() {
		Map<String,Object> model = new HashMap<>();
		model.put("content", "Привет, друг!");
		return model;
	}

	@RequestMapping(value = METHOD_AGENTS, method = RequestMethod.GET)
	public Map<String, List<Agent>> getUsers() {
		Map<String, List<Agent>> result = new HashMap<>();
		List<Agent> agents = DataGenerator.generateAgents();
		result.put("agents", agents);
		return result;
	}

	@RequestMapping(value = METHOD_TRADE_POINTS, method = RequestMethod.GET)
	public Map<String, List<TradePoint>> getTradePoints() {
		Map<String, List<TradePoint>> result = new HashMap<>();
		List<TradePoint> tradePoints = DataGenerator.generateTradePoints();
		result.put("trade-points", tradePoints);
		return result;
	}

	@RequestMapping(value = METHOD_ROUTES, method = RequestMethod.GET)
	public Map<String, List<Route>> getRoutes(
			@RequestParam(value = "agent_id", required = false) final Integer agentId
	) {
		Map<String, List<Route>> result = new HashMap<>();
		List<Route> routes = routesService.getRoutes(agentId);
		result.put("routes", routes);
		return result;
	}

	@RequestMapping(value = METHOD_ROUTES, method = RequestMethod.DELETE)
	public ResponseEntity<AnswerModel<Boolean>> deleteRoute(
			@RequestParam(value = "route_id") Integer routeId
	) {
		ResponseEntity<AnswerModel<Boolean>> response = null;
		if (routesService.deleteRoute(routeId)) {
			response = new ResponseEntity<>(new AnswerModel<>(true, "success"), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(new AnswerModel<>(false, "not found"), HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@RequestMapping(value = METHOD_ROUTES, method = RequestMethod.POST)
	public ResponseEntity<AnswerModel<Integer>> addRoute(
			@RequestBody Route route
	) {
		if (route.getId() != null) {
			return new ResponseEntity<>(new AnswerModel<>(null, "id_must_be_empty"), HttpStatus.BAD_REQUEST);
		} else {
			Integer id = routesService.addOrUpdateRoute(route);
			return new ResponseEntity<>(new AnswerModel<>(id, "success"), HttpStatus.OK);
		}
	}

	@RequestMapping(value = METHOD_ROUTES, method = RequestMethod.PUT)
	public ResponseEntity<AnswerModel<Integer>> updateRoute(
			@RequestBody Route route
	) {
		if (route.getId() == null) {
			return new ResponseEntity<>(new AnswerModel<>(null, "id_required"), HttpStatus.BAD_REQUEST);
		} else {
			Integer id = routesService.addOrUpdateRoute(route);
			if (id == null) {
				return new ResponseEntity<>(new AnswerModel<>(null, "id_not_found"), HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(new AnswerModel<>(id, "success"), HttpStatus.OK);
			}
		}
	}
}
