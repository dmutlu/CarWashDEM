# CarWash by DEM
In this project I have figured out how to configure IntelliJ IDEA 2017.3 to use Gradle 4.3 in order to support lambdas in Android Development.

# Steps to Gradle 4.3

1. Goto https://gradle.org/releases/ and download the binary of latest release.
2. Extract the gradle.zip to a permanent location which you can easily find. In my case, (D:\Program Files\JetBrains\Gradle)
3. Open IntelliJ and goto [Build, Execution, Deployment] -> [Build Tools] -> [Gradle] and select the radio button which says "Use local gradle distribution".
4. Select the path for your Gradle home. This should be the same path as in step 2. Ensure that the Gradle JVM is set to Java 1.8.0 or higher. Press Apply then OK.

# Configuring Your Project to Use Gradle 4.3

1. Edit your {gradle-wrapper.properties} under [gradle/wrapper] and make sure the distributionUrl is set to https\://services.gradle.org/distributions/gradle-4.1-all.zip
2. Edit your {gradle.properties} and add "android.injected.build.model.only.versioned=3", without quotes.
3. Edit your top-level {build.gradle} and replicate my {build.gradle} found here: https://github.com/dmutlu/CarWashDEM/blob/master/build.gradle
4. Edit your app {build.gradle} and replicate my {build.gradle} found here: https://github.com/dmutlu/CarWashDEM/blob/master/app/build.gradle
5. Finally, goto [File] and select [Invalidate Caches / Restart]. When prompted, invalidate and restart.
