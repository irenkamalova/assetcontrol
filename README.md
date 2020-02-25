# School Bus reservation system REST API

## Installation

Package jar (it also will run all tests) then execute it:

```
mvn clean package
cd target 
java -jar assetcontrol-1.0-SNAPSHOT.jar
```

The solution covered by tests using SpringBoot test and JUnit5, it could be executed by:
```
mvn test
```

## Notes
- Database provided as h2db and __initialized__ on start by data in ```src/main/resources/data.sql```
- I built __indexes__ on data that has lots access for reading (see ```src/main/resources/data.sql```)
- I use [LogBook](https://github.com/zalando/logbook) for intercepting and __logging__ requests/responses
- I use MVC model, to controllers handle different types of requests (the way to improve architecture - up __two services__ on two endpoints, the first will handle all requests to route controller and the second will handle all requests to reservarion controller)
- I use Jackson library to convert data to JSON model
- I use SpringBootTest and JUnit5 to provide __test__ coverage

## Usage

[http://localhost:8080/](http://localhost:8080) will redirect you to swagger-api.html page, where you can find methods to work with app.
#### Examples
```
curl -X POST "http://localhost:8080/service/reservations/rA/122022" -H "accept: text/plain" -H "Content-Type: application/json" -d "{ \"busStop\": \"string\", \"childName\": \"string\"}"
```
Response:
Code 400, ```{
  "message": "Bus with name string doesn't exist"
}```
```
curl -X POST "http://localhost:8080/service/reservations/rA/122023" -H "accept: text/plain" -H "Content-Type: application/json" -d "{ \"busStop\": \"b0\", \"childName\": \"string\"}"
```
Response:
Code 200, ```c292d247-9475-4fc0-8b4a-7140ee719115``` - id of created reservation
```
curl -X GET "http://localhost:8080/service/reservations/rA/122023" -H "accept: application/json"
```
Response:
Code 200, list:
```
[
  {
    "reservationId": "c292d247-9475-4fc0-8b4a-7140ee719115",
    "route": {
      "routeId": "0",
      "routeName": "rA"
    },
    "date": "122023",
    "childName": "string",
    "busStop": {
      "busStopId": "0",
      "busStopName": "b0"
    }
  }
]
```
Get reservation by id:
```
curl -X GET "http://localhost:8080/service/reservations/rA/122023/c292d247-9475-4fc0-8b4a-7140ee719115" -H "accept: application/json"
```
```
{
  "reservationId": "c292d247-9475-4fc0-8b4a-7140ee719115",
  "route": {
    "routeId": "0",
    "routeName": "rA"
  },
  "date": "122023",
  "childName": "string",
  "busStop": {
    "busStopId": "0",
    "busStopName": "b0"
  }
}
```
Delete reservation:
```
curl -X DELETE "http://localhost:8080/service/reservations/rA/122023/c292d247-9475-4fc0-8b4a-7140ee719115" -H "accept: */*"
```
Response: Code 200, ```Successfully deleted```

```
curl -X DELETE "http://localhost:8080/service/reservations/rA/122023/c292d247-9475-4fc0-8b4a-7140ee719115" -H "accept: */*"
```
Code 400, ```{
  "message": "Reservation with such ID doesn't exist"
}```
