# MongoDB Examples

##Preface

Following instructions will let you set up your MongoDB server locally.

### How to install MongoDB server locally
1. Visit https://www.mongodb.com/download-center#community
2. Download correct installation package 
3. Install using suggested settings

### How to run terminal
To run terminal go to `C:\Program Files\MongoDB\Server\4.0\bin` and run `mongo.exe`

### How to run MongoDB Compass 
1. To run graphical interface compass, go to `C:\Users\tomic\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\MongoDB Inc`
and run `MongoDB Compass Community.exe`
2. Now you need provide credentials for your MongoDB server to connect to it.
- Hostname : `localhost` or `127.0.0.1`
- Port : `27017`
- Favorite Name : `LOCAL_MONGO` or any name you like

### Install Robo 3T 
1. Visit [https://robomongo.org/](https://robomongo.org/) download and install 

### Validate 
To validate if all is working fine:

1. Run your terminal and paste following command:
```aidl
db.test.save( { a: 1 } )
```
2. Execute following query
```aidl
db.test.find()
```
you should get similar output:
```aidl
{ "_id" : ObjectId(5879b0f65a56a454), "a" : 1 }
```
3. Congratulations, you are ready to use your database server!
