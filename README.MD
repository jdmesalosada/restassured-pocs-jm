##**Pre-requisites:**
* Java 1.8 (JDK)
* Gradle
* Intellij IDEA Community Edition

##**Run tests:**
```
./gradlew clean test
```

Log information. Add the -i argument:

``` ./gradlew clean test -i ```

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
./gradlew clean test --tests ReqRes2Tests.getSingleUserTest
```

##**Run tests by tags:**
```
./gradlew clean test -Dgroups="e2e"
```

## You can create task in gradle whether include or exclude the tests to run
```
./gradlew e2eTest
```
##**Playlist to follow:**

[Youtube](https://www.youtube.com/playlist?list=PLeo6Q1inqlOf2yUIT1SUal8eViM6u4PBn)