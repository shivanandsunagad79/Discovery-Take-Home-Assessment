# Discovery-Take-Home-Assessment
This library lets you use for the web application automation. This maven project uses the Core-Test-utils-Discovery-Take-Home-Assessment (https://github.com/shivanandsunagad79/Core-Test-utils-Discovery-Take-Home-Assessment) library projects as a snapshot in POM.

  <!-- driver utils module from gloalLogic core test utils project -->
    <dependency>
        <groupId>com.globalLogic.discovery</groupId>
	      <artifactId>driver-utils</artifactId>
	      <version>0.0.1.BUILD-SNAPSHOT</version>
    </dependency>
Java, cucumber, selenium and junit dependencies are used in this project.
A very beautiful cucumber report get generated once the runner class run in cmd using maven commond (mvn test) in the target folder.

This project uses maven project structure.

    Main/Java : It has application web page classes.
    Main/Resources: Log resource added.
    Test/Java: It has a runner class and stepdefenation classes.

Runner Class read the configuration from the properties file added in the config folder .
Stepdefnation folder has Base Step class where in all the webpage classes are instantiated to use in the stepdefination classes and all the reusable common method added to it.

    Test/Resources: All the features file added here.

Task 2 text file is added in this project directory only with the name PopularShowsList.txt. A sample text file can be found in the repository.
