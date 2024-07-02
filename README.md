# Parcial 1 ARSW

This program allows the user to launch a RESTful server, Concurrent test client and WebClient

[AWS server](http://ec2-54-162-85-101.compute-1.amazonaws.com:8080/)

2024/07/2


## Architecture 

![Parcial 1 ARSW](https://github.com/Parralol/Parcial1ARSW/assets/110953563/bf86367f-5a20-42af-bb8b-5d39e63b1862)

In the following Architecture diagram we can see how the user connects directly to the JS client, along side it is also usable the concurrent test client, each java component is represented by the red filled cube, so every pettition gets to java application and gets redirected to java Controller via the /status and /rest paths with the quer and type values, if the /status path is selected, the controller will deliver the corresponding image, if the /rest path is selected, then it will comence the communication protocol, first it will create the url with the given data in APIsend, then it gets to the client(invoker) which handles the comunication with the API service, then the comunication flows back again from the client(invoker) to Parcial1Controller, then to Parcial1Application and finally in the JS client.

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
mvn clean package
```

### Acceptance test

#### AWS

In the following acceptance test

![image](https://github.com/Parralol/Parcial1ARSW/assets/110953563/a84a9b12-7e3a-4d4c-8890-178dfc42bc4f)

 we can see how the concurrent client and the server responds correspondly, however we get thos responses because we lack the proper keys to get the types of searches in the mock data besides the terminal

 ![image](https://github.com/Parralol/Parcial1ARSW/assets/110953563/c53e61f4-4492-4d18-9364-05ec839b24c9)

Here we can see how the program works at the 8080 port, searching MSFT with the TIME SERIES INTRADAY type of search, we get the following response from the server as seen by the client, in the server the we make the same search a couple of times to get

![image](https://github.com/Parralol/Parcial1ARSW/assets/110953563/337bfb4d-a497-4344-b113-d6484e8d948a)

the "cacheworking" message, this indicates that the cache inside of the system is working properly

#### Locally

![image](https://github.com/Parralol/Parcial1ARSW/assets/110953563/cdb19d2c-ab40-44b3-a323-26e840315279)

In the following image we can see how the search is being used in a local enviroment, the search, as it should, gives the following answer via localhost in the 8080 port

![image](https://github.com/Parralol/Parcial1ARSW/assets/110953563/e0a057ec-f610-4d00-b294-d39a8b9af572)

as we can see, if we search it again we'll get the "cacheworking" message, indicating that the cache of the program works as it should

![image](https://github.com/Parralol/Parcial1ARSW/assets/110953563/42f06a99-93f6-459c-b175-12708a70889f)

Once we execute the concurrent test client, we get the following responses as it should, given the limitations in the API service

![image](https://github.com/Parralol/Parcial1ARSW/assets/110953563/89fb321a-4c34-457e-9c1a-a1e33c578e14)

Once executed the Concurrent test client we can see how the server resolved all the petitions made by it.

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
