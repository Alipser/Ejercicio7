package Entity;

public class Author {

    public Author(){
    };

    public Author(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;

    }

    private int id;

    private String name;

    private String nationality;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
