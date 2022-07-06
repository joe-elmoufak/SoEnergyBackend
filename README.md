# SoEnergyBackend
SoEnergy Backend Test

I have created some simple api tests to test various parts of the test apis given to me.

As entering params as part of the request makes no effect to the final response of these apis I have been a bit limited by what I could test but have managed to produce some tests with a bit of variety in what we are testing for.

I have used PicoContainer to inject the dependancies to step defs and classes.

I have used Cucumber for extra readability but just using Junit without the cucumber wrapper is equally valid. I wasnt sure what was preferred so decided to go with cucumber...

I also used appche http to make all of the api calls and close the instance after a scenario is finished (which will allow better parallel testing)

Maven retrieves the dependancies so just right click on the maven pom and rebuild the project to get them onto your local.

Either run the tests from the IDE (eg IntelliJ or from the command line by going to the project root and running "mvn clean test"

The test runs in github actions via linux with the actions file included in the repo.

# With regards to non-functional requirements....

I have used tools in the past such as loadrunner or Jmeter to test the speed and reliability of the api. 

Within the context of these tests there are security tests you can do such as making a request from an enpoint that requires a token in the header (and ommitting the token) or hacking a enpoint with query params to try and retrive information that you would otherwise need to login for (eg have a token for)

