# MongoDB - Collections

### Collections

1. Create `users` collection using following syntax:
```aidl
db.createCollection("users")
```
2. Validate if `users` collection has been succesfully created by executing:
```aidl
show collections
```
3. To remove collection use
```aidl
db.users.drop()
```

### Documents

1. To insert document to collection:
```aidl
db.users.insert({name: "Janusz", age: 65, city: "Zgierz"})
```
You can also use `save` method instead of `insert`. This will work the same for new documents.
2. To query document use:
```aidl
db.users.find().pretty()
```
you should receive something like:
```aidl
{
        "_id" : ObjectId("5b4b37448647df45373064d2"),
        "name" : "Janusz",
        "age" : 65,
        "city" : "Zgierz"
}
```
3. Try to add more elements to your collection of users:
```aidl
db.users.insert({name: "Grażyna", age: 63, city: "Zgierz"})
db.users.insert({name: "Mariusz", age: 45, city: "Zgierz", car: "Passat tdi 2.0"})
db.users.insert({name: "Bożena", age: 44, city: "Zgierz"})
db.users.insert({name: "Sebastian", age: 25, city: "Łódź", car: "BMW E36"})
db.users.insert({name: "Karyna", age: 24, city: "Łódź"})
```
4. Now play with some queries to see, how you can get data from mongo:
4a. Query for all documents having city defined as Zgierz:
```aidl
db.users.find({"city":"Zgierz"}).pretty()
```
do the same to get people from Łódź
4b. Query for all people older than 40:
```aidl
db.users.find({"age":{$gt:40}}).pretty()
```
play with other operators:

| Operation            | Syntax                        | 
| ---------------------|:-----------------------------:| 
| Equality             |`{<key>:<value>}`              | 
| Less Than            |`{<key>:{$lt:<value>}}`        | 
| Less Than Equals     |`{<key>:{$lte:<value>}}`       | 
| Greater Than         |`{<key>:{$gt:<value>}}`        |  
| Greater Than Equals  |`{<key>:{$gte:<value>}}`       | 
| Not Equals           |`{<key>:{$ne:<value>}}`        |  
4c. Query combined predicates, to get all people from Łódź, younger then 25
```aidl
db.users.find(
   {
      $and: [
         {city: "Łódź"}, {age:{$lt:25}}
      ]
   }
).pretty()
```
Change this query replacing `$and` oparator with `$or` operator

## Exercise

Create collection `animals` and add some animals:
Below are some examples:
```aidl
{
    name: "Reksio",
    type: "dog",
    age: 2,
    owner: "Janusz",
    hair_length: "short",
    character: "agresive"
},
{
    name: "Gold fish",
    type: "fish",
    age: 4,
    owner: "Grażyna"
},
{
    name: "Filemon",
    type: "cat",
    age: 1,
    owner: "Sebastian",
    live_number: 1
},
{
    name: "Pan Kracy",
    type: "cat",
    age: 15,
    owner: "Genowefa",
    live_number: 7
},
{
    name: "Pimpuś",
    type: "dog",
    age: 2,
    owner: "Sebastian",
    hair_length: "short",
    character: "agresive"
},
{
    name: "Reks",
    type: "dog",
    age: 5,
    owner: "Mariusz",
    hair_length: "long",
    character: "calm"
},
```
Take note, there is no schema defined, and some animals differ from others.

Now when you are done, try to execute some queries:
1. Return only dogs.
2. Return only animals owned by Sebastian.
3. Return animals older or equal to 5 years.
4. Return all dogs or cats.

