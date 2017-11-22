Optimize Prime
--------------
Our homepage can be found here: <br />
<a href="http://foodtruckop.com" target="_blank">http://foodtruckop.com</a>


Overview
--------
Optimize Prime's project to put all your food truck needs in one place! If you feel the need to satisfy your food truck cravings, you can use our web service to find food trucks that can do just that!

Want that delicious Korean fusion or the ice cream in plant pots that hits the right spot? Look no more!


Authors
-------
* [Adrian Cuellar](https://github.com/AACuellar96)
* [John Wang](https://github.com/johnHaloWang)
* [Rachel Chiang](https://github.com/raechiang)
* [Todd Nguyen](https://github.com/toddnguyen11)
* [Allen Sartoonian](https://github.com/asartoonian)


Environment Setup
-----------------
1. Install the latests [Maven](http://maven.apache.org/download.cgi).
2. Install the latest [Eclipse](http://www.eclipse.org/).
3. Make sure your Eclipse has Maven installed (It should have been included in the latest version of the Eclipse)
4. Install a MySQL Server. We recommend installing [XAMPP](https://www.apachefriends.org/index.html) for easy MySQL setup and execution.


Importing the Project into Eclipse
----------------------------------
1. File &rightarrow; Import &rightarrow; Maven &rightarrow; Existing Maven Projects
2. Select the directory containing the pom.xml file
3. You're all set!


Building the Project for the First Time
---------------------------------------
1. Right-click on the project root folder &rightarrow; Maven &rightarrow; Update Project


Running the Project Locally
----------------------------------------
1. Make sure your MySQL server is running. ![XAMPPImage1](./src/main/resources/static/images/xampp1.jpg)
2. In Eclipse, locate App.java in src/main/java source folder and right-click on it &rightarrow; Run As &rightarrow; Java Application
3. Verify the running process in your web browser by the following URLs:

- http://localhost:8080/
- http://localhost:8080/cs480/ping

**NOTE:** Our project employs the use of a self-signed SSL certificate in order to enable HTTPS. Your browser (Chrome/Firefox/Safari/Internet Explorer) might warn you about an unsafe site. Do NOT worry! Our site is perfectly safe. We only use HTTPS to get your current location using geolocation, nothing else. 


Employing on a Live Server
--------------------------
TODO

Optional
--------
If you are on Windows, you can simply open a command prompt in the root folder and type in "mavenScriptWindows" and your server will run. This is useful if you are only editing the front end and do not want to update Maven manually in Eclipse.

You can do the same thing in Linux/MacOS. Simply create a startScript.sh file (a Bash file) and type in the following commands:

`mvn package`

`java -jar ./target/cs480-1.0.jar`

Then, give startScript.sh the ability to execute by typing in the terminal:

`chmod +x startScript.sh`

Lastly, you can run the script with `./startScript.sh`