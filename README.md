Local instructions:

#Initial Setup (it is assumed that Java 8 is already set up)

1.	Download Eclipse Luna: Eclipse IDE for Java Developers, version: Luna Service Release 2 (4.4.2)
2.	Download MongoDB v3.4.2
3.	Download Spring Framework RELEASE 4.3.7

#Mongo Setup

1. 	Install MongoDB.
2. 	Open the terminal in the MongoDB folder.
	```
 	$ cd Server/3.4/bin
	```
3. 	Copy all 4 .csv files to this folder: protected_areas_na.csv, StormEvents_details-ftp_v1.0.csv, Monthly_All_GEO.csv, storms_sorted2.csv
	```
 	$ start mongod.exe	
	$ start mongo.exe
	```
4.	In Mongo, create the database called stormdb, then exit Mongo.
	```
	$ create stormdb
	$ exit
	```
5.	Import the data into stormdb with the following commands:
	```
	$ mongoimport -d stormdb -c areas --type csv --file protected_areas_na.csv --headerline
	$ mongoimport -d stormdb -c storm_events --type csv --file StormEvents_details-ftp_v1.0.csv --headerline
	$ mongoimport -d stormdb -c weather_conditions --type csv --file Monthly_All_GEO.csv --headerline
	$ mongoimport -d stormdb -c predictions --type csv --file storms_sorted2.csv --headerline
	```
#Opening project in Eclipse

1.	Clone this project.
2.	Open new workspace in Eclipse, same folder the project is located.
3.	File > New > Java Project.
4.	Deselect "Use default location" and click Browse.
5.	Select the project.
6.	Click Finish and wait for the project to load.
7.	In the Package Manager, right click on the project and select Properties.
8.	Java Build Path > Libraries > Add Library > JRE System Library.
9.	Select "Alternate JRE" and select the folder containing Java 8.
10.	If it is not there, click Installed JREs > Add > Standard VM and select the folder containing Java 8 and click Ok.
11.	In the Package Explorer, right click on the project and select Configure > Convert to Maven.
12.	Right click on the project and Run As > Maven Clean.
13.	Run As > Maven generate-sources.
14.	Run As > Maven Install.
15.	Before running the application, start the mongod server:
	```
	$ start mongod.exe
	```
16. Finally, to run the application, Run As > Spring Boot App.
17. Application is running at localhost:8080.
