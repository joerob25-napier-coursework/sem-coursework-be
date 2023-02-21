# USE CASE:2 Produce a report on a given country

## CHARACTERISTIC INFORMATION

### Related Requirements
1. As a Data Gatherer, I need to be able to generate a report which shows all the countries in the world organised 
   by largest population to smallest
2. As a Data Gatherer, I need to be able to generate a report which shows all the countries in a continent organised
   by largest population to smallest
3. As a Data Gatherer, I need to be able to generate a report which shows all the countries in a region organised 
   by largest population to smallest
4. As a Data Gatherer , I need to be able to generate a report which shows the top populated countries in the world 
   where I specify the number of countries to be shown
5. As a Data Gatherer, I need to be able to generate a report which shows the top populated countries in a continent
   where I specify the number of countries to be shown
6. As a Data Gatherer, I need to be able to generate a report which shows the top populated countries in a region
   where I specify the number of countries to be shown

### Initiating Actor 
Data Gatherer.

### Actor's Goal
As a *Data Gatherer* I want *to produce a report on a given country* so that *I can present it to my weekly management
meeting.*

### Participating Actors
Management who attend the meeting need to be shown information on given Countries

### Preconditions
We know the given Country. Database contains current data on Countries.

### Postconditions
A report on the given Country is available for the Data Gatherer to present at their weekly management meeting.

## MAIN SUCCESS SCENARIO
1. Given country information is needed by Data Gatherer for management meeting
2. Data Gatherer extracts current country's information which has been given
3. Data Gatherer presents given country's information to weekly management meeting

## EXTENSIONS
**Country does not exist**:
    - Data Gatherer informs the meeting members that the country does not exist.
**Failed End Condition**:
    - No report is produced

## Release

Release 1.2