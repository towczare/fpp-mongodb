package pl.sda.nosql.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;

public class MongoDemo {
    public static void main(String[] args) throws UnknownHostException {

        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("books");
        MongoCollection<Document> books = db.getCollection("books");

//        /**** Insert ****/
//        // create a document to store key and value
//        Document elementarz = new Document("title", "Elementarz Pierwszoklasisty")
//                .append("isbn", "9788302022432");
//        books.insertOne(elementarz);


        Document findPublished = new Document("publishedDate", new Document("$ne", null));
        Document orderBy = new Document("title", 1);
        MongoCursor<Document> cursor = books.find(findPublished).sort(orderBy).iterator();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println(
                    "Book " + doc.get("title") + ", published at " + doc.get("publishedDate")
                );
            }
        } finally {
            cursor.close();
        }
    }
}
