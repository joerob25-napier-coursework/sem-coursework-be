# USE CASE:4 Produce a report on a given Capital City

## CHARACTERISTIC INFORMATION

### RELATED REQUIREMENTS
1. As a Data Gatherer, I need to be able to generate a report which shows all the capital cities in the world organised 
   by largest population to smallest
2. As a Data Gatherer, I need to be able to generate a report which shows all the capital cities in a continent 
   organised by largest population to smallest
3. As a Data Gatherer, I need to be able to generate a report which shows all the capital cities in a region organised 
   by largest population to smallest
4. As a Data Gatherer, I need to be able to generate a report which shows the top populated capital cities in the world
   where I specify the number of capital cities to be shown
5. As a Data Gatherer, I need to be able to generate a report which shows the top populated capital cities in a 
   continent where I specify the number of capital cities to be shown
6. As a Data Gatherer, I need to be able to generate a report which shows the top populated capital cities in a region 
   where I specify the number of capital cities to be shown

### INITIATING ACTOR
Data Gatherer.

### ACTOR'S GOAL
As a *Data Gatherer* I want *to produce a report on a given Capital City* so that *I can present it to my weekly
management meeting.*

### PARTICIPATING ACTORS
Management who attend the meeting need to be shown information on given Capital Cities

### PRECONDITIONS
We know the given Capital City. Database contains current data on Capital Cities.

### POSTCONDITIONS
A report on the given Capital City is available for the Data Gatherer to present at their weekly management meeting.

## MAIN SUCCESS SCENARIO
1. Given Capital City's information is needed by Data Gatherer for management meeting
2. Data Gatherer extracts current Capital City's information which has been given
3. Data Gatherer presents given Capital City's information to weekly management meeting

## EXTENSIONS
**Capital City does not exist**:
 - Data Gatherer informs the meeting members that the Capital City does not exist.
**Failed End Condition**
 - No report is produced

## RELEASE
Release 1.0