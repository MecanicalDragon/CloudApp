### Config server
1. Init a git repo and commit properties files.
    - **application.properties** is common for all
    - **service-name.properties** is specific and has precedence
2. Add **spring-cloud-config-server** dependency.
3. Declare **spring.cloud.config.server.git.uri** property for server-app. Specify a path to repository in it.
4. Add **@EnableConfigServer** annotation to the application class.
5. Visit *<http://host:port/service-name/default>* to see the properties of **service-name**
### Config client
1. Add **spring-cloud-starter-config** dependency
2. Create **bootstrap.properties** in resources directory. Declare properties there:
    - **spring.application.name** - "service-name", for example
    - **spring.cloud.config.uri** - uri of config-server
3. Add annotation **@RefreshScope** to classes, that use remote-fetched properties
4. Configure actuator
    - Add **spring-boot-starter-actuator** dependency
    - add **management.endpoints.web.exposure.include=*** to the properties for allowing access to the actuator data
5. Post empty request to *<http://host:port/actuator/refresh>* to refresh properties (before that you need to commit changes in properties files)
### Eureka server
1. Add **spring-cloud-starter-netflix-eureka-server** dependency
2. Add **@EnableEurekaServer** annotation to application class 
### Eureka client
1. Add dependencies:
    - **spring-cloud-starter-netflix-eureka-client**
    - **spring-cloud-starter-netflix-eureka-server**
2. Specify a properties:
    - **eureka.client.service-url.defaultZone=<http://host:port/eureka>** - url to eureka server
    - **eureka.client.register-with-eureka=true** - to allow self-registration on the server
    - **eureka.client.fetch-registry=true** - to allow fetching info from the server
3. Add **@EnableDiscoveryClient** annotation in application class
4. Determine a **spring.application.name** property in bootstrap.properties
5. Create class, that contains **Discovery Client** (take a look into a code)
6. You can see all instances of the application with that rest-controller (refresh can take up to a minute)
### Circuit Breaker
1. Add **spring-cloud-starter-netflix-hystrix** dependency
2. Add **@EnableCircuitBreaker** annotation to application class
3. Add **@HystrixCommand** annotation to a method, that can fail. Specify the name of the substitute method.
### Load Balancing
1. Add **spring-cloud-starter-netflix-ribbon** dependency
2. Mark with **@LoadBalanced** annotation the bean, that interacts with load balanced service
3. Define **eureka.client.service-url.defaultZone=<http://host:port/eureka>** property.<br/>
##### To tune load balancing manually follow next steps:
4. Add **@RibbonClient** annotation to application class. Specify there:
    - **spring.application.name** of the service, that's wanted to be load balanced.
    - additional configuration class (look into code)
5. Define properties:
    - **hello-service.ribbon.eureka.enabled=false**
    - **hello-service.ribbon.listOfServers** host:port,host:port
    - **hello-service.ribbon.ServerListRefreshInterval** in milliseconds
### ZuulProxy
1. Add **spring-cloud-starter-netflix-zuul** dependency
2. Add **@EnableZuulProxy** annotation to application class
3. Define properties: 
    - **zuul.routes.hello.path**=/hello/** - request pattern
    - **zuul.routes.hello.url**=http://localhost:21010 - redirect url
