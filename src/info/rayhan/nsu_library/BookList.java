package info.rayhan.nsu_library;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kingRayhan |
 * @date 03-DEC-16
 * @time 2:22am
 */
public class BookList {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty author;
    
    public BookList(String id , String name , String author){
        this.id          =  new SimpleStringProperty(id);
        this.name          =  new SimpleStringProperty(name);
        this.author          =  new SimpleStringProperty(author);
    }
    //Getters
    public String getId() {
        return id.get();
    }
    public String getName() {
        return name.get();
    }
    public String getAuthor() {
        return author.get();
    }
    // Seters
    public void setName(String value) {
        name.set(value);
    }
    public void setAuthor(String value) {
        author.set(value);
    }
    
}
