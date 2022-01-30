# MobileWebAPIFramework
This framework contains Test cases for : 
1. Android mobile app.
2. Chrome Web UI.
3. API.

##Libraries used are :
1. Cucumber
2. Testng
3. Appium
4. RestAssured
5. Gson
6. Json
7. Extent Report

This project can be executed from CLI using "mvn test" command. 
Or Test runner file can be triggered as individual test file.
#Test
location : /src/test/java/com/features
1. apiTest.feature, contains test related to WebService.
2. jQuery.feature, contains test related to Web UI app.
3. testSelendroid.feature, contains test related to mobile app. 
#Report
Extent report has been used as primary report.
report would be generated as base folder by the name of "Extent_Test_Report.html"
Screenshot for failed test cases will be automatically link to failed test in Extent report.

#Build Steps
1. Clone this repo in your system.
2. Open project in IDE (intelli-j/Eclipse).
3. Compile the project using Maven.
4. APPIUM server could be run through external app else will be started automatically by the framework.
5. trigger TestRunner.java as test file.

