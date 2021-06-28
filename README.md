# Microservices with SpringBoot


* Proxy with Feign
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
