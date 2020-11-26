package net.andreinc.mn.crud.backend.dtos.requests;

import java.util.Set;

public class CreateBookDTO {

    private Long id;
    private String title;
    private int pages;
    private Set<Long> authorIds;

    public CreateBookDTO() {
    }

    public CreateBookDTO(Long id, String title, int pages, Set<Long> authorIds) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.authorIds = authorIds;
    }

    public CreateBookDTO(String title, int pages, Set<Long> authorIds) {
        this.title = title;
        this.pages = pages;
        this.authorIds = authorIds;
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

    public Set<Long> getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(Set<Long> authorIds) {
        this.authorIds = authorIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
