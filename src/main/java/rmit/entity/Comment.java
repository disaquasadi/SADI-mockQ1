package rmit.entity;

import javafx.geometry.Pos;
import org.springframework.jmx.export.annotation.ManagedNotification;

import javax.persistence.*;
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postId",nullable = false)
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Comment() {
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
