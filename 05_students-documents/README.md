# MongoDB - Students

### Import bigger set of data

1. In the `dataset` location or under following url https://raw.githubusercontent.com/ozlerhakan/mongodb-json-files/master/datasets/students.json you can find student rating data set. 

2. Save document in your computer and import it using Mongo Compass Community:
- Create new database `students`
- Create new collection `students`
- From upper menu choose Collection -> Import Data
- Select saved `students.json` file and import it.
3. Validate results by executing following query:
(Note you might need to restart your terminal)
```aidl
use students
db.students.find().limit(1)
```
you should get something like following:
```aidl
{"_id":0,"name":"aimee Zank","scores":[{"score":1.463179736705023,"type":"exam"},{"score":11.78273309957772,"type":"quiz"},{"score":35.8740349954354,"type":"homework"}]}
```

## Exercises
1. Find 5 best results for homework.

