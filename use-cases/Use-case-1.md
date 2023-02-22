# USE CASE:1 Produce a Report on population

## CHARACTERISTIC INFORMATION

### Related Requirements
1. As a Data Gatherer, I need to be able to generate a report which shows the population of people,
   people living in cities and people not living in cities in each continent
2. As a Data Gatherer, I need to be able to generate a report which shows the population of people, 
   people living in cities and people not living in cities in each region
3. As a Data Gatherer, I need to be able to generate a report which shows the population of people,
   people living in cities and people not living in cities in each country
4. As a Data Gatherer, I need to be able to access the population of the world
5. As a Data Gatherer, I need to be able to access the population of a continent
6. As a Data Gatherer, I need to be able to access the population of a region
7. As a Data Gatherer, I need to be able to access the population of a country
8. As a Data Gatherer, I need to be able to access the population of a district
9. As a Data Gatherer, I need to be able to access the population of a city

### Initiating Actor
Data Gatherer.

### Actor's Goal
As a *Data Gatherer* I want *to produce a report on population for a continent/region/country* so that
*I can present it to my weekly management meeting.*

### Participating Actors
Management who attend the meeting need to be shown population information.

### Preconditions
We know the continent/region/country. Database contains current population data.

### Postconditions
A report on population is available for the Data Gatherer to present at their weekly management meeting.

## MAIN SUCCESS SCENARIO
1. Population information is needed by Data Gatherer for management meeting
2. Data Gatherer extracts current Population information for the given continent/region/country
3. Data Gatherer presents population information to weekly management meeting

## EXTENSIONS
**continent/region/country does not exist**:
    - Data Gatherer informs the meeting members that the continent/region/country does not exist.
**Failed End Condition**:
    - No report is produced

## Release

Release 1.3