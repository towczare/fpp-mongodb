# MongoDB - Selecting fields from documents

### Update operation

1. Assuming you have collection of users from first module. Return `name` from documents using following query:
```aidl
db.users.find({}, {name:1})
```
## Exercises

Play with your animals collection and update:
1. Return names and ages of all animals.
2. Now return all `live_number` of all your cats older than 3
