# MongoDB - Update documents

### Update operation

1. Assuming you have collection of users from first module. Return all documents executing following query:
```aidl
db.users.find()
```
you should get something like following:
```aidl
{ "_id" : ObjectId("5b4b37448647df45373064d2"), "name" : "Janusz", "age" : 65, "city" : "Zgierz", "car" : "VW Pasat TDI 2.0" }
{ "_id" : ObjectId("5b4b38918647df45373064d3"), "name" : "Grażyna", "age" : 60, "city" : "Zgierz" }
{ "_id" : ObjectId("5b4b38a68647df45373064d4"), "name" : "Mariusz", "age" : 40, "city" : "Zgierz" }
{ "_id" : ObjectId("5b4b39278647df45373064d5"), "name" : "Bożena", "age" : 44, "city" : "Zgierz" }
{ "_id" : ObjectId("5b4b39278647df45373064d6"), "name" : "Sebastian", "age" : 25, "city" : "Łódź", "car" : "BMW E36" }
{ "_id" : ObjectId("5b4b39298647df45373064d7"), "name" : "Karyna", "age" : 24, "city" : "Łódź" }
```
note your `_id` properties will most likely differ from above ones.
2. Now update Grażyna object using following query: 
```aidl
db.users.update({"_id" : ObjectId("5b4b38918647df45373064d3")},{$set:{age: 61}})
```
3. To add new field you can use this command:
```aidl
db.users.update({"_id" : ObjectId("5b4b38918647df45373064d3")},{$set:{sex: "female"}})
```
...now do the same with rest documents
4. You can also use save method to totally replace document
Use following to replace Sebastian document with totally new fields
```aidl
db.users.save(
   {
      "_id" : ObjectId("5b4b39278647df45373064d6"), "name" : "Sebastian", "age" : 26, "city" : "Warszawa", "car" : "BMW E46", dogs: ["Pitbul", "Doberman"]
   }
)
```
5. You can also update multiple objects using following update query
```aidl
db.users.update({city: "Zgierz"}, {$set:{street:"Targowa"}},{multi:true})
```
following text should appear:
```aidl
WriteResult({ "nMatched" : 4, "nUpserted" : 0, "nModified" : 3 })
```
## Exercises

Play with your animals collection and update:
1. `Reksio` document to make him older `+1`
2. `Pan Kracy` document with new field `alive: false`
3. All dogs with new field `"number of paws": 4`
4. Replace animal of `Grażyna` with:
```aidl
{
    name: "Gadułka",
    type: "bird",
    age: 1,
    owner: "Grażyna"
},
```