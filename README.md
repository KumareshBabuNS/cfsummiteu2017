# osb-software-as-a-service-broker
## Description

An Cloud Foundry Service Broker implementing the Open Service Broker API missing concrete implementations of a distinct service.   
Supports sharing applications on Cloud Foundry to be shared with other users of Cloud Foundry via the Cloud Foundry marketplace.  
Uses MongoDB Database for management of shared service instances as a backend.   
Configuration files and deployment scripts must be added.  
Concrete Service logic and binding logic has to be added.  

This service broker has been written during the hackathon at the Cloud Foundry Summit 2017 in Basel.

## Contributors
- Christian Brinker, evoila
- Konstantin Kiess, Volkswagen Financial Services
- Christian Müller, evoila
- Yannic Remmet, evoila

## Start with this example
1. Clone it.
2. Build it. `mvn clean install`
3. Provide a valid configuration. 
4. Run it or push it to Cloud Foundry.

## Usage
The service broker assumes to be used by creating an service instance in some space of the SaaS providers spaces inside cloud foundry. This service instance gets provided some parameter provided regarding the service offering which has to be presented in the marketplace via the -c paremeter of cf create-service-instance.

These are:
- service_name
- service_description
- plan_name
- plan_description
- url


  
