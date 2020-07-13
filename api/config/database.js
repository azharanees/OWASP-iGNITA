//Set up mongoose connection
    const mongoose = require('mongoose');
    const MongoClient = require("mongodb").MongoClient;
    const mongoDB = 'mongodb://localhost:27017';
    var database, collection;
    mongoose.connect(mongoDB, {useNewUrlParser: true, dbName: "RAF"});
    MongoClient.connect(mongoDB, {useNewUrlParser: true},function (err,client){
        if(err) {
            console.log('Error occurred while connecting to MongoDB Atlas...\n',err);
       }
       console.log('Connected...');

       database = client.db("iGNITA");
        collection = database.collection("people");
        console.log("Connected to `" + "database" + "`!");
        
       client.close();
    });
   
    mongoose.Promise = global.Promise;

module.exports = mongoose; 
