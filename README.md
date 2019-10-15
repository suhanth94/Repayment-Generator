# Repayment_Assignment

This assignment is implemented with Java 8, Maven Build and Spring Boot.

* Clone the GIT Repository
* Import Project with the help of pom.xml
* Start the application from IDE (like Intellij) or command line.
* Application by default runs on port 8080
* Hit API via any rest client (like Postman) with URI: http://localhost:8080/generate-plan
* Provide Input Params like described below:

Sample Request:

```json
{
 "loanAmount": "7000",
 "nominalRate": "5.0",
 "duration": 5,
 "startDate": "2019-01-01T00:00:01Z"
}
```
Sample Response:

```json

[
    {
        "borrowerPaymentAmount": 1417.55,
        "date": "2019-01-01T00:00:01.000+0000",
        "initialOutstandingPrincipal": 7000.0,
        "interest": 29.17,
        "principal": 1388.38,
        "remainingOutstandingPrincipal": 5611.62
    },
    {
        "borrowerPaymentAmount": 1417.55,
        "date": "2019-02-01T00:00:01.000+0000",
        "initialOutstandingPrincipal": 5611.62,
        "interest": 23.38,
        "principal": 1394.17,
        "remainingOutstandingPrincipal": 4217.45
    },
    {
        "borrowerPaymentAmount": 1417.55,
        "date": "2019-03-01T00:00:01.000+0000",
        "initialOutstandingPrincipal": 4217.45,
        "interest": 17.57,
        "principal": 1399.98,
        "remainingOutstandingPrincipal": 2817.47
    },
    {
        "borrowerPaymentAmount": 1417.55,
        "date": "2019-04-01T00:00:01.000+0000",
        "initialOutstandingPrincipal": 2817.47,
        "interest": 11.74,
        "principal": 1405.81,
        "remainingOutstandingPrincipal": 1411.66
    },
    {
        "borrowerPaymentAmount": 1417.54,
        "date": "2019-05-01T00:00:01.000+0000",
        "initialOutstandingPrincipal": 1411.66,
        "interest": 5.88,
        "principal": 1411.66,
        "remainingOutstandingPrincipal": 0.0
    }
]
```
