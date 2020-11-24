package net.andreinc.mn.crud.backend.commands;

public class CreateBook {
    private String title;
    private int pages;

    public CreateBook(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public CreateBook() {
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
