# USE CASE:1 Produce a Report on population

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *Data Gatherer* I want *to produce a report on population for a continent/region/country* so that *I can present it to my weekly management meeting.*

### Scope
Company
what system is considered black-box under design?

### Level

Primary task.

### Preconditions

We know the continent/region/country. Database contains current population data.

### Success End Condition

A report on population is available for the Data Gatherer to present at their weekly management meeting.

### Failed End Condition

No report is produced.

### Primary Actor

Data Gatherer.

### Trigger

Population information is needed by Data Gatherer for management meeting

## MAIN SUCCESS SCENARIO
1. Population information is needed by Data Gatherer for management meeting
2. Data Gatherer extracts current Population information for the given continent/region/country
3. Data Gatherer presents population information to weekly management meeting


## EXTENSIONS

**continent/region/country does not exist**:
    1. Data Gatherer informs the meeting members that the continent/region/country does not exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.1