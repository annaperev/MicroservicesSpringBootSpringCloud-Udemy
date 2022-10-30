# Microservices with SpringBoot

[Intro to webservices](#intro-to-webservices)


## Intro to webservices

Web service - w3c defenition - software system designed to support interoperable machine-to-machine interaction over the network

3 keys:
- designed for application-to-aplication interaction
- should be interoperable - not platform dependent
- should allow communication over the network




* Proxy with Feig
* Naming Server Eureka
* Load Balance Feigh + Eureka
* Gateway
* Circuit Breaker


watch.sh - to test Circuit Breaker, script what make calls endpoint in infinite circle

run in cmd: 
```
./watch.sh curl http://localhost:8000/sample-api
```

about Circuit Breaker

https://resilience4j.readme.io/docs/circuitbreaker
https://resilience4j.readme.io/docs/getting-started-3
