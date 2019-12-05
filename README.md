# Overview
This took longer than expected, mostly due to me being a little rusty on my hibernate & spark.
Due to running overtime, I've skipped a few steps that realistically would be required in a prod system.

Missing:
- Thorough Exception handling
- Rest Model - Should not be using the db entity as the rest entity
- Validation - Should be validating everything submitted by the user

I didn't end up doing docker, due to time constraints.


#Setup
- Mysql Required
- Java 8

in mysql:
```
CREATE SCHEMA `ecms` ;
```

The Application is setup to create-drop the tables, and re-insert test data at startup

#Rest Calls
The apis for /client /employee /quote /invoice follow the same format:
- GET /employee - lists all employees
- POST /employee - adds or updates an employee
- GET /employee/:id - gets a single employee
- DELETE /employee/:id - deletes the employee

# Git History
I had to delete the git history due to committing something with my name on it