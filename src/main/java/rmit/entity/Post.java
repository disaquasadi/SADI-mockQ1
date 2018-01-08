package rmit.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "post")
public class Post {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId", nullable = false)
    private Author author;

    @OneToMany(fetch = FetchType.EAGER ,mappedBy = "post")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
