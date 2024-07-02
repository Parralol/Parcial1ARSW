# Parcial 1 ARSW

This program allows the user to launch a RESTful server, Concurrent test client and WebClient
2024/07/2


## Architecture 

![Architecture](https://github.com/Parralol/Lab06ARSW/assets/110953563/e703ab22-b119-4165-8fab-f84a9e4474e2)

As seen by the following diagram the user connects via browser to use the program, then he must connect via http using the 3000 port, this is because the React based client is working in that service, the client, of course, is provided by a cloud machine deployed in Amazon EC2, each connection starts sending data to our second EC2 server deployed to withstand Spring and to connect via http using the port 8080 (tomcat), this server will work as our Sync service for each client, this is because this service manages all dots drawn by each client, the server delivers an array as Json to all the clients so they get proccessed and interpreted.

Once all has been done the clients draws all the dots (or erases everything given the user input), if the client decides to delete everything then in the server all data will be erased, there are some commands that cannot be used by the client and those are status and points, this exists just for debbuging reasons and verifying how everything works, however if seeing that is what the user desires the only thing that is needed to do is to try and connect via browser to the data server, each path that is described in the connection between Lab06Application and Lab06Controller is being delivered once, not all petitions at once.

And so this is the why of this architecture.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

First you need the following java version (command to see your current java version below)

```
java -version
```

![image](https://github.com/Parralol/Lab05ARSW/assets/110953563/87192abf-bebd-4d74-ad1e-e62a94405c43)

to see the maven version we are using we need to enter the following command, also this is the version of Maven this programm uses

```
mvn -version
```

![image](https://github.com/Parralol/Lab05ARSW/assets/110953563/8711cee6-e4ba-47ae-b46c-8984142890bb)


### Installing

First clone this proyect into your own system, then 

```
mvn clean install
```

### Acceptance test

https://github.com/Parralol/Lab06ARSW/assets/110953563/cac2d4bf-4d8c-4023-9336-6d97e072d54e

in case the video does not load, simply press F5 to refresh the github tab so that the video downloads as intended

In the video we can see the EC2 instance hosting the server with various instances of the client running locally, as seen in the video the drawing updates and allows for multiple people drawing at the same time.

https://github.com/Parralol/Lab06ARSW/assets/110953563/664d7a14-1329-4660-9d1d-5fe338c549bb

in this video we test that the delete button works properly

https://github.com/Parralol/Lab06ARSW/assets/110953563/9d18ef29-ee58-404e-b1ad-3f8d30913548

here we can see the client and the server both deployed in EC2.


## Generating javadoc

Simply enter the following commands

```
mvn javadoc:javadoc
```

```
mvn javadoc:jar
```

```
mvn javadoc:aggregate
```

```
mvn javadoc:aggregate-jar
```

```
mvn javadoc:test-javadoc 
```

## Deployment

### Server deployment

**IN ORDER FOR THIS PROGRAM TO WORK, YOU'LL NEED TO EXECUTE THE PROGRAM ON THE FOLDER YOU WANT TO WORK WITH, WITH THE FILES YOU WANT TO WORK WITH**

if you want to use the programm after using the package command we use

```
mvn spring-boot:run
```

after the server has initialized, you'll have to use the client to properly see the server working, but even then you can enter to the following URLS to ensure that your server is working properly.

http://localhost:8080/status  --> to know if the server is running

http://localhost:8080 --> start the javascript client

http://localhost:8080/rest?quer=MSFT&type=TIME_SERIES_DAILY_ADJUSTED --> The query that will be sent to the server, this contains three data parameters:

/rest: Path that the server will accept to start the RESTful API search

quer: value that posseses the name of the stock that is being searched

type: the search type.

### Concurrent test client deployment

in order to deploy and use the Concurrent test client you'll need to enter the code below after you did the startup

```
mvn -e exec:java -Dexec.mainClass=parcial.arsw.parcial1.ConcurrentController
```

or (depending on your system)

```
mvn -e exec:java -Dexec'.mainClass=parcial.arsw.parcial1.ConcurrentController'
```


you'll see the response in the terminal

## Built With

### Server side

* [Maven](https://maven.apache.org/) - Dependency Management
* [Java](https://www.oracle.com/java/technologies/) - Programming Language
* [Spring](https://spring.io/) - Framework
  
### Client side
* [HTML 5](https://html.spec.whatwg.org/multipage/) - HiperText Markup Lenguaje
* [JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript) - lightweight interpreted programming language

  
## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Santiago Parra** - *Initial work* - [Parralol](https://github.com/Parralol)
