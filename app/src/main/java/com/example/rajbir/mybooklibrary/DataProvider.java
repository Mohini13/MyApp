package com.example.rajbir.mybooklibrary;

/**
 * Created by rajbir on 2015-12-10.
 */
public class DataProvider {
    private String name;
    private String isbn;
    private String author;
    private String issuedOn;
    private String issuedBy;

    public DataProvider(String name,String isbn, String author, String issuedOn, String issuedBy)
    {
        this.name=name;
        this.isbn=isbn;
        this.author=author;
        this.issuedOn=issuedOn;
        this.issuedBy=issuedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(String issuedOn) {
        this.issuedOn = issuedOn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
