# BDD with Selenium and Cucumber #
This project contains the source code used to test SFDC out of the box features.  The idea 
is to have business analysts or product owner's write a BDD feature file.  Then, the development team will take the feature file and write functional tests with Selenium and JUnit 4.

BDD frameworks are supported across multiple programming languages.  In this case, we used Java; However, my preference is to used Python with Cucumber and Behave.  

## Getting Started ##
For this short tutorial we are used Eclipse - 1. it's free 2. it has all the plugins that we need.  It's a gradle project, so you can easily migrate to IntelliJ or other IDE.

### Pre-Requisites ###
This project requires the ChromeDriver at a minimum.  Other drivers can be added.
To install the ChromeDriver on OSX use the Homebrew package manager.

```
:>brew tap homebrew/cask

:>brew cask install chromedriver
```

[ChromeDriver Home Page](http://chromedriver.chromium.org)


### Quick Start ###

1. Clone this git Repo.
2. Import into your IDE of choice.
3. Refresh the Gradle project (Eclipse IDE)
4. Open the application.properties file and add your orgs username and password (Don't share)
5. Configure your IDE to use JUnit 4.
6. Run the CucumberTestRunner.class

### Project Utilities
This project has 3 utilities classes.

1. ApplicationUtil - This class load the application.properties file.
2. RunEnvironment - This class is a Java Bean for the WebDriver and properties Map.
3. EnvironmentManager - Loads the driver if the driver has not been loaded (Lazy Init).  Also manages the driver (close() and shutdown()).In this case we are only using chromedriver on OSx.  You can easily add other Drivers and Windows as the OS.


