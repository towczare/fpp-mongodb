# MongoDB - Students

### Import bigger set of data

1. In the `dataset` location or under following url https://raw.githubusercontent.com/ozlerhakan/mongodb-json-files/master/datasets/catalog.books.json you can find book catalogue data set. 

2. Save document in your computer and import it using Mongo Compass Community:
- Create new database `books`
- Create new collection `books`
- From upper menu choose Collection -> Import Data
- Select saved `catalog.books.json` file and import it.
3. Validate results by executing following query:
(Note you might need to restart your terminal)
```aidl
use books
db.books.find().limit(1)
```
you should get something like following:
```aidl
{ "_id" : 1, "title" : "Unlocking Android", "isbn" : "1933988673", "pageCount" : 416, "publishedDate" : ISODate("2009-04-01T07:00:00Z"), "thumbnailUrl" : "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ableson.jpg", "shortDescription" : "Unlocking Android: A Developer's Guide provides concise, hands-on instruction for the Android operating system and development tools. This book teaches important architectural concepts in a straightforward writing style and builds on this with practical and useful examples throughout.", "longDescription" : "Android is an open source mobile phone platform based on the Linux operating system and developed by the Open Handset Alliance, a consortium of over 30 hardware, software and telecom companies that focus on open standards for mobile devices. Led by search giant, Google, Android is designed to deliver a better and more open and cost effective mobile experience.    Unlocking Android: A Developer's Guide provides concise, hands-on instruction for the Android operating system and development tools. This book teaches important architectural concepts in a straightforward writing style and builds on this with practical and useful examples throughout. Based on his mobile development experience and his deep knowledge of the arcane Android technical documentation, the author conveys the know-how you need to develop practical applications that build upon or replace any of Androids features, however small.    Unlocking Android: A Developer's Guide prepares the reader to embrace the platform in easy-to-understand language and builds on this foundation with re-usable Java code examples. It is ideal for corporate and hobbyists alike who have an interest, or a mandate, to deliver software functionality for cell phones.    WHAT'S INSIDE:        * Android's place in the market      * Using the Eclipse environment for Android development      * The Intents - how and why they are used      * Application classes:            o Activity            o Service            o IntentReceiver       * User interface design      * Using the ContentProvider to manage data      * Persisting data with the SQLite database      * Networking examples      * Telephony applications      * Notification methods      * OpenGL, animation & multimedia      * Sample Applications  ", "status" : "PUBLISH", "authors" : [ "W. Frank Ableson", "Charlie Collins", "Robi Sen" ], "categories" : [ "Open Source", "Mobile" ] }```
```
4. To search for partial where query, you can use regex formulas like following:
```aidl
db.books.findOne({"title" : {$regex : ".*Jaguar.*"}});
```
should find:
```aidl
{
        "_id" : 19,
        "title" : "Jaguar Development with PowerBuilder 7",
        "isbn" : "1884777864",
        "pageCount" : 550,
        "publishedDate" : ISODate("1999-08-01T07:00:00Z"),
        "thumbnailUrl" : "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/barlotta2.jpg",
        "shortDescription" : "Jaguar Development with PowerBuilder 7 is the definitive guide to distributed application development with PowerBuilder. It is the only book dedicated to preparing PowerBuilder developers for Jaguar applications and has been approved by Sybase engineers and product specialists who build the tools described in the book.",
        "longDescription" : "Jaguar Development with PowerBuilder 7 is the definitive guide to distributed application development with PowerBuilder. It is the only book dedicated to preparing PowerBuilder developers for Jaguar applications and has been approved by Sybase engineers and product specialists who build the tools described in the book.    Jaguar Development with PowerBuilder 7 focuses on getting you up to speed on Jaguar and PowerBuilder, and it is packed with code samples to guide you every step of the way. It covers each step involved in application development, from setting up the development environment to deploying a production application.    Even a PowerBuilder developer with no experience in distributed technologies or Jaguar CTS will learn what it takes to build an application. Jaguar Development with PowerBuilder 7 covers:    Developing Component-centric Applications  Building Jaguar CTS Components/Clients  CORBA  Adaptive SQL Anywhere  Adaptive Server Enterprise  and lots more!",
        "status" : "PUBLISH",
        "authors" : [
                "Michael Barlotta"
        ],
        "categories" : [
                "PowerBuilder",
                "Client-Server"
        ]
}
```
5. To count all documents use:
```aidl
db.books.count()
```
## Exercises - Duck challenge 
```aidl
        ,----,
   ___.`      `,
   `===  D     :
     `'.      .'
        )    (                   ,
       /      \_________________/|
      /                          |
     |                           ;
     |               _____       /
     |      \       ______7    ,'
     |       \    ______7     /
      \       `-,____7      ,'   jgs
^~^~^~^`\                  /~^~^~^~^
  ~^~^~^ `----------------' ~^~^~^
 ~^~^~^~^~^^~^~^~^~^~^~^~^~^~^~^~  
```

1. Search all books from `in Action` series.
2. How many books in collection have status `PUBLISH`
3. How many books is `PUBLISH` and from `in Action` series.
4. Which book have biggest number of pages and how many?
5. What is the oldest book in whole collection, and what is publish year?
    hint to looks only for Documents with filled property
    ```aidl
    find({"publishedDate":{$exists: true}})
    ```
6. How many authors is the highest number in given example? What are the titles?
    hint, here is query sorting number of authors starting from lowest number:
    ```aidl
    db.books.aggregate([{$project: {title: 1, numberOfAuthors: {$size: "$authors"}}},{$sort:{"numberOfAuthors":1}}])
    ```
7. How many books is related to category of `Java`?
8. Assume, we are just going to publish some book. We are going to publish books with title `Distributed Agile in Action` 
Update status of this book to `PUBLISH` and change publishedDate to current date using `new Date()`
9. Some books doesn't have any categories, try to find them and add some categories to few of them.
