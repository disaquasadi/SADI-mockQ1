
package rmit.service;


import org.springframework.transaction.annotation.Transactional;
import rmit.entity.Author;
import rmit.entity.Comment;
import rmit.entity.Post;

import java.util.List;
public interface OrderService {


    //SAVE


    //generic
    public void save(Object object);


    public void saveAuthor(Author author);

    public void savePost(Post post);

    public void saveComment(Comment comment);


    //DELETE
    public void deleteAuthor(Author author);

    public void deletePost(Post post);

    public void deleteComment(Comment comment);

    public List<Author> getAllAuthors();

    public List<Post> findPosts(String keyword);

    public List<Comment> findComments(String keyword);

    public List<Post> findPostsByAuthor(Author author);

    //Get By Id
    public Post getPostById(int id);

    public Author getAuthorById(int id);

    public Comment getCommentById(int id);



}