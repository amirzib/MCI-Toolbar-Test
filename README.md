
# Testing toolbar MCI app in Appium with java
---
## Section 1: Quick Overview
#### Overview
Here we are writing some test (health) for toolbar mci app with gherklin syntax.

#### Road map
We expecting everything in toolbar and some submenu work correctly.
#### Configuration
Important configurations are notice in [configuration file]().

#### Change Log
--

---
## Section 2: Comprehensive look

#### Code Environment

We are using VSCode with this setting below:
*.vscode/settings.json*
```
{
    "java.configuration.updateBuildConfiguration": "interactive",
    "java.compile.nullAnalysis.mode": "automatic",

    "cucumberautocomplete.steps": [
        "appium/src/test/java/com/adak/step_defenitions/USSD_steps.java"
    ],

    "cucumberautocomplete.syncfeatures": "appium/src/test/resources/feature",
    "cucumberautocomplete.strictGherkinCompletion": true,
    "cucumberautocomplete.smartSnippets": true,
    "cucumberautocomplete.stepsInvariants": true,
}
```
We are cofigure our step in ```cucumberautocomplete.steps``` so we can easily go to each file with holding ```ctrl``` and click on each sentences in scenarios.

#### Application Dependencies 

Using [```Maven repo```](https://mvnrepository.com/) to add these dependencies.
```
testng
java-client
jackson-xml-databind
jackson-dataformat-xml
junit-jupiter-api
cucumber-java
cucumber-junit
slf4j-api
slf4j-simple
testng-engine
junit
```
These plugins are important and should be added.
```
maven-clean-plugin
maven-resources-plugin
maven-compiler-plugin
maven-surefire-plugin
maven-failsafe-plugin
```
Maven surfire plugin should be like this:
```
<plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.2.5</version>
        <dependencies>
          <dependency>
          <groupId>org.apache.maven.surefire</groupId>
          <artifactId>surefire-junit47</artifactId>
          <version>3.2.5</version>
          </dependency>
        </dependencies>
      </plugin>
```

#### Folder Structure
We have our features are in `src/test/resources/feature**.feature` and our steps are in `src/test/java/com/adak/step_defenitions/**.java`
We have our test runner in `src/test/java/com/adak/Runner/runnerTest.java`

## Section 3: Acknowledgment
#### Contributors
Amir ghara zibaie (Mr.Alf)

#### Links
--
