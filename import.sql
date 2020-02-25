INSERT INTO routes (route_id, name) VALUES ('0', 'rA');
INSERT INTO routes (route_id, name) VALUES ('1', 'rB');


INSERT INTO bus_stops (bus_id, name) VALUES ('0', 'b0');
INSERT INTO bus_stops (bus_id, name) VALUES ('1', 'b1');
INSERT INTO bus_stops (bus_id, name) VALUES ('2', 'b2');
INSERT INTO bus_stops (bus_id, name) VALUES ('3', 'b3');
INSERT INTO bus_stops (bus_id, name) VALUES ('4', 'b4');
INSERT INTO bus_stops (bus_id, name) VALUES ('5', 'b5');
INSERT INTO bus_stops (bus_id, name) VALUES ('6', 'b6');
INSERT INTO bus_stops (bus_id, name) VALUES ('7', 'b7');
INSERT INTO bus_stops (bus_id, name) VALUES ('8', 'b8');
INSERT INTO bus_stops (bus_id, name) VALUES ('9', 'b9');


INSERT INTO routes_stops (route_id, bus_id) VALUES ('0', '0');
INSERT INTO routes_stops (route_id, bus_id) VALUES ('0', '1');
INSERT INTO routes_stops (route_id, bus_id) VALUES ('0', '2');
INSERT INTO routes_stops (route_id, bus_id) VALUES ('0', '3');
INSERT INTO routes_stops (route_id, bus_id) VALUES ('0', '4');

INSERT INTO routes_stops (route_id, bus_id) VALUES ('1', '5');
INSERT INTO routes_stops (route_id, bus_id) VALUES ('1', '6');
INSERT INTO routes_stops (route_id, bus_id) VALUES ('1', '7');
INSERT INTO routes_stops (route_id, bus_id) VALUES ('1', '8');
INSERT INTO routes_stops (route_id, bus_id) VALUES ('1', '9');

SELECT * FROM routes;
SELECT * FROM routes_stops;
