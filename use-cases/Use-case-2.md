# USE CASE:2 Produce a report on a given country

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *Data Gatherer* I want *to produce a report on a given country* so that *I can present it to my weekly management meeting.*

### Scope
Company
what system is considered black-box under design?

### Level

Primary task.

### Preconditions

We know the given country. Database contains current data on countries.

### Success End Condition

A report on the given country is available for the Data Gatherer to present at their weekly management meeting.

### Failed End Condition

No report is produced.

### Primary Actor

Data Gatherer.

### Trigger
Given country's information is needed by Data Gatherer for management meeting.

## MAIN SUCCESS SCENARIO
1. Given country information is needed by Data Gatherer for management meeting
2. Data Gatherer extracts current country's information which has been given
3. Data Gatherer presents given country's information to weekly management meeting


## EXTENSIONS

**Country does not exist**:
1. Data Gatherer informs the meeting members that the country does not exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0