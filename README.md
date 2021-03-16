# Package delivery console application
 _BACKEND DEVELOPER INTERVIEW TASK_

Command line program that keeps a record of packages processed. Each package information consists of weight (in kg) and destination postal code. Datea is kept in memory.

- read user input from console, user enters line consisting of weight of package and destination postal code
- once per minute - write output to console, each line consists of postal code and total weight of all packages for that postal code
- process user command “quit”, when user enters quit to command line as input, program should exit
- take and process command line argument specified at program run – filename of file containing lines in same format as user can enter in command line. This is considered as initial load of package information
- handle invalid input of user (it is up to you how, describe implemented behaviour in readme file)

## Runnin the App
Open your favorite Terminal and run these commands.

1. Clone this repository
2. Go to release package-delivery folder
```bash
cd package-delivery
```
3. run 
```bash
gradle build
```
4. run Application
```bash
java -jar build\libs\PackageDelivery.jar
```

## Tech
PackageDelivery app uses

- [Gradle] - HTML enhanced for web apps!
- [Eclipse IDE]

## License

MIT

**Free Software, enjoy it!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [gradle]: <https://gradle.com/>
   [eclipse IDE]: <https://www.eclipse.org/>