This file describe monitoringservice application.

This application provide two REST methods for that operations:
    1) submitting current measurements (meters data for gas and water) for user;
    2) show history of previous submitted

REST-api is implemented over jax-rs with jersey realisation. For both REST methods is used POST request.
REST-implementation: com.offsidegaming.monitoringapplication.rest.MonitoringApplicationRest;
path for submit: /monitoringservice/monitoring/service/submit
path for history: /monitoringservice/monitoring/service/history

IoC container is Spring.

The application use database HSQLDB (in-memory mode) with one table MEASUREMENTS. Database initialising and filling by
Spring-jdbc over jdbc:embedded-database construction in applicationContext and filling by sql-scripts.
Work with database is done over Hibernate with one entity class: MeasurementEntity

Authentication and authorization was not implemented. For user identification is used http header of request.
SessionContext (stub) use this header for determinate userId, that need for our operations. It's implied that user was
authorized by side service.

todo: add logger, add authentication and authorization mechanism, add tests

For build use command: mvn install
For application launch is need to deploy monitoringservice.war at Java Servlet Container (for example Apache Tomcat).
Request examples:

1) for submit

POST /monitoringservice/monitoring/service/submit HTTP/1.1
Content-Type: application/json
USER_SESSION: 777

{
	"gasMeasurement":"100.00",
	"waterMeasurement":"200.00",
	"hotWaterMeasurement":"300.00"
}

2) for history

POST /monitoringservice/monitoring/service/history HTTP/1.1
USER_SESSION: 777