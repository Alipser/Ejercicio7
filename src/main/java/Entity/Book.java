package Entity;

public class Book {
private int id;
private String title;

private String yearPublication;

private Double price;

private int authorID;

private Author author;

    public Book(){
    }
    public Book(int id, String title, String yearPublication, Double price, int authorID) {
        this.id = id;
        this.title = title;
        this.yearPublication = yearPublication;
        this.price = price;
        this.authorID = authorID;
    }

    public Book( String title, String yearPublication, Double price, int authorID) {
        this.id = id;
        this.title = title;
        this.yearPublication = yearPublication;
        this.price = price;
        this.authorID = authorID;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearPublication='" + yearPublication + '\'' +
                ", price=" + price +
                ", author=" + authorID +
                '}';
    }
}
