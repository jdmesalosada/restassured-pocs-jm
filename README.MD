##**Pre-requisites:**
### Requirements
* [openjdk 17](https://adoptium.net/temurin/releases/?version=17)
* [Gradle gradle-8.5](https://gradle.org/releases/)
* [Maven 3.9.6](https://maven.apache.org/download.cgi)

##**Run tests:**
```
gradlew clean test -Denv=dev
```

##**Run test in a specific environment:**
```
gradlew clean test -Denv=dev
gradlew clean test -Denv=prod

```

##**Run tests from powershell commandline:**
```
.\gradlew clean test -Denv=dev
```

##**Run test and generate report:**
```
./gradlew clean test
./gradlew allureReport
./gradlew allureServe
```

##**Run just one test:**
```
gradle clean test --tests ReqRes2Tests.getSingleUserTest
```


##**Playlist to follow:**

[Youtube](https://www.youtube.com/playlist?list=PLeo6Q1inqlOf2yUIT1SUal8eViM6u4PBn)
