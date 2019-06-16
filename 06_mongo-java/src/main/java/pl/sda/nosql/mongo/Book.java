package pl.sda.nosql.mongo;

import org.bson.Document;

public class Book {

    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public static Book fromDocument(Document doc) {
        String title = doc.getString("title");
        int pageCount = doc.getInteger("pageCount");

        return new Book(title, pageCount);
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


}
