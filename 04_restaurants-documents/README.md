# MongoDB - Restaurants

### Import bigger set of data

1. In the `dataset` location or under following url https://raw.githubusercontent.com/ozlerhakan/mongodb-json-files/master/datasets/restaurant.json you can find restaurant data set. 

In the following repository you can find other interesting free sets of data you can play with.
2. Save document in your computer and import it using Mongo Compass Community:
- Create new database `restaurants`
- Switch to database `restaurants`
- Create new collection `restaurants`
- From upper menu choose Collection -> Import Data
- Select saved `restaturant.json` file and import it.
3. Validate results by executing following query:
(Note you might need to restart your terminal)
```aidl
use restaturants
db.restaurants.find().limit(1)
```
you should get something like following:
```aidl
{ "_id" : ObjectId("55f14312c7447c3da7051b26"), "URL" : "http://www.just-eat.co.uk/restaurants-cn-chinese-cardiff/menu", "address" : "228 City Road", "address line 2" : "Cardiff", "name" : ".CN Chinese", "outcode" : "CF24", "postcode" : "3JH", "rating" : 5, "type_of_food" : "Chinese" }
```
4. To sort your documents use following query:
```aidl
db.restaurants.find({},{name: 1}).sort({name: 1}).limit(10)
```
5. To show how many restaurants we imported, execute following query:
```
db.restaurants.count({})
```

## Exercises
1. Find 5 best chinese restaurants.
2. Find worse pizza restaurant
3. How many restaurant is in `outcode` `WS10` area?
4. Which one is the best? What food type do they serve?
5. Add 3 your favourite restaurants from local city (use google or tripadvisor to search for required data like rating, postcode, url, address etc.)

💡 Your turn 🤔, prepare 3 own riddles.
