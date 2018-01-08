package rmit.service;

import javafx.geometry.Pos;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import rmit.entity.*;
import rmit.entity.Author;

import java.util.List;

@Transactional
public class HibernateOrderService implements OrderService{

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateOrderService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    //Generall
    public void save(Object object){
        sessionFactory.getCurrentSession().save(object);
    }

    public void saveAuthor(Author author){
        sessionFactory.getCurrentSession().save(author);
    }

    public void savePost(Post post){
        sessionFactory.getCurrentSession().save(post);
    }

    public void saveComment(Comment comment){
        sessionFactory.getCurrentSession().save(comment);
    }

    public void deleteAuthor(Author author) {
        sessionFactory.getCurrentSession().delete(author);
    }

    public void deletePost(Post post) {
        sessionFactory.getCurrentSession().delete(post);
    }

    public void deleteComment(Comment comment) {
        sessionFactory.getCurrentSession().delete(comment);
    }


    //GetAll

    public List<Author> getAllAuthors(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Author.class);
        return criteria.list();
    }
    public List<Post> getAllPosts(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Post.class);
        return criteria.list();
    }
    public List<Comment> getAllComment(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Comment.class);
        return criteria.list();
    }



    //GetById

    public Author getAuthorById(int id){
        return (Author)sessionFactory.getCurrentSession().get(Author.class, id);
    }
    public Post getPostById(int id){
        return (Post) sessionFactory.getCurrentSession().get(Post.class, id);
    }
    public Comment getCommentById(int id){
        return (Comment) sessionFactory.getCurrentSession().get(Comment.class, id);
    }

    //GetByName
    public List<Author> getAuthorByName(String name){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Author.class);
        criteria.add(Restrictions.like("name",name, MatchMode.ANYWHERE));
        return criteria.list();
    }
    public List<Comment> getCommentByContent(String content){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Comment.class);
        criteria.add(Restrictions.like("content",content, MatchMode.ANYWHERE));
        return criteria.list();
    }
    public List<Post> getPostByContent(String content){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Post.class);
        criteria.add(Restrictions.like("content",content, MatchMode.ANYWHERE));
        return criteria.list();
    }

    //mock answer
    public List<Post> findPostsByAuthor(Author author) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("FROM Post p WHERE p.author.id = :authorId");
        query.setLong("authorId", author.getId());
        return query.list();
    }

    public List<Post> findPosts(String keyword) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("FROM Post p WHERE p.content LIKE :keyword");
        query.setString("keyword","%"+ keyword + "%");
        return query.list();
    }

    public List<Comment> findComments(String keyword) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("FROM Comment c WHERE c.content LIKE :keyword");
        query.setString("keyword","%"+ keyword + "%");
        return query.list();
    }

}
