package pl.sda.nosql.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryMongoDB implements BookRepository {

    private MongoClient mongo;
    private MongoDatabase db;

    public BookRepositoryMongoDB() {
        this.mongo = new MongoClient("localhost", 27017);
        this.db = mongo.getDatabase("books");
    }

    @Override
    public List<Book> findAll() {

        List<Book> booksCollection = new ArrayList<>();

        MongoCollection<Document> books = db.getCollection("books");
        Document findPublished = new Document("publishedDate", new Document("$ne", null));
        Document orderBy = new Document("title", 1);
        MongoCursor<Document> cursor = books.find(findPublished).sort(orderBy).iterator();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                Book book = Book.fromDocument(doc);
                booksCollection.add(book);
//                System.out.println(
//                    "Book " + doc.get("title") + ", published at " + doc.get("publishedDate")
//                );
            }
        } finally {
            cursor.close();
        }

        return booksCollection;
    }
}
