# USE CASE:3 Produce a report on a given City

## CHARACTERISTIC INFORMATION

### RELATED REQUIREMENTS
1. As a Data Gatherer, I need to be able to generate a report which shows all the cities in the world organised
   by largest population to smallest
2. As a Data Gatherer, I need to be able to generate a report which shows all the cities in a continent organised 
   by largest population to smallest
3. As a Data Gatherer, I need to be able to generate a report which shows all the cities in a region organised 
   by largest population to smallest
4. As a Data Gatherer, I need to be able to generate a report which shows all the cities in a country organised 
   by largest population to smallest
5. As an Data Gatherer, I need to be able to generate a report which shows all the cities in a district organised 
   by largest population to smallest
6. As a Data Gatherer, I need to be able to generate a report which shows the top populated cities in the world
   where I specify the number of cities to be shown
7. As a Data Gatherer, I need to be able to generate a report which shows the top populated cities in a continent 
   where I specify the number of cities to be shown
8. As a Data Gatherer, I need to be able to generate a report which shows the top populated cities in a region 
   where I specify the number of cities to be shown
9. As a Data Gatherer, I need to be able to generate a report which shows the top populated cities in a country 
   where I specify the number of cities to be shown 
10. As a Data Gatherer, I need to be able to generate a report which shows the top populated cities in a district 
    where I specify the number of cities to be shown

### INITIATING ACTOR 
Data Gatherer

### ACTOR'S GOAL
As a *Data Gatherer* I want *to produce a report on a given City* so that *I can present it to my weekly management 
meeting.*

### PARTICIPATING ACTORS
Management who attend the meeting need to be shown information on given Countries

### PRECONDITIONS
We know the given City. Database contains current data on Cities.

### POSTCONDITIONS
A report on the given City is available for the Data Gatherer to present at their weekly management meeting.

## MAIN SUCCESS SCENARIO
1. Given City's information is needed by Data Gatherer for management meeting
2. Data Gatherer extracts current City's information which has been given
3. Data Gatherer presents given City's information to weekly management meeting

## EXTENSIONS
**City does not exist**:
 - Data Gatherer informs the meeting members that the City does not exist.
**Failed End Condition**
 - No report is produced

## RELEASE

Release 1.0