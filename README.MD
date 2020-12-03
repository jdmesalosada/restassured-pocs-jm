##**Pre-requisites:**
* Java 1.8 (JDK)
* Gradle
* Intellij IDEA Community Edition

##**Run tests:**
```
gradle clean test
```

##**Run test in a specific environment:**
```
gradle clean test -Denv=dev
gradle clean test -Denv=prod

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