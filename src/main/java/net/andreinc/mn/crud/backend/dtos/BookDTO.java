package net.andreinc.mn.crud.backend.dtos;

import java.util.Set;

public class BookDTO {

    public static class AuthorsInfo {
        private Long id;
        private String firstName;
        private String lastName;
        public AuthorsInfo() {}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    private Long id;
    private String title;
    private int pages;
    private Set<AuthorsInfo> authors;

    public BookDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Set<AuthorsInfo> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorsInfo> authors) {
        this.authors = authors;
    }
}
