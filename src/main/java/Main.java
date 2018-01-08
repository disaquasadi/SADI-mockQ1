
import rmit.config.AppConfig;
import rmit.entity.*;
import rmit.service.HibernateOrderService;
import rmit.service.OrderService;
import rmit.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by CoT on 10/13/17.
 */
public class Main {


    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AppConfig.class);

        context.refresh();

        PersonService personService = (PersonService) context.getBean("personService");
        OrderService orderService = context.getBean(OrderService.class);

//        Person person = new Person();
//        person.setName("henry");
//        personService.savePerson(person);
//
//        Course sadi = new Course();
//        sadi.setName("Sadi");
//        sadi.setPerson(person);
//        personService.save(sadi);
//
//        Course wp = new Course();
//        wp.setName("Web programming");
//        wp.setPerson(person);
//        personService.save(wp);

//        Person newPerson = personService.getPersonById(1);
//        //Do nothing
//        System.out.println(newPerson.getCourses().size());
//        for(Course course: newPerson.getCourses()){
//            System.out.println(course.getName());
//        }

//        Course newCourse = personService.getCourseById(1);
//        System.out.println(newCourse.getPerson().getName());
        System.out.println(" ---------------------------------------------------------------------");

        //AUTHOR
        Author jack = new Author();
        jack.setName("zed");
        jack.setEmail("sis.zed@gmail.com");
        jack.setNickname("Dester");
        orderService.saveAuthor(jack);

        Author john = new Author();
        john.setName("lel");
        john.setEmail("lelol");
        john.setNickname("lelelelele");
        orderService.saveAuthor(john);

        //POST
        Post post1 = new Post();
        post1.setContent("i am zed ");
        post1.setAuthor(jack);
        orderService.save(post1);

        Comment comment = new Comment();
        comment.setContent("aloalo");
        comment.setAuthor(jack);
        comment.setPost(post1);
        orderService.save(comment);

        Comment comment2 = new Comment();
        comment2.setContent("kwndkwencjkwencjknwejkcwkcx kwecx");
        comment2.setAuthor(jack);
        comment2.setPost(post1);
        orderService.save(comment2);

        //-------------------------------------

        Post post2 = new Post();
        post2.setContent("Hahahahaha");
        post2.setAuthor(john);
        orderService.save(post2);

        Comment comment3 = new Comment();
        comment3.setContent("aloalo");
        comment3.setAuthor(john);
        comment3.setPost(post2);
        orderService.save(comment3);

        System.out.println(orderService.getAuthorById(1).getPosts().size());

        List<Post> posts = orderService.findPosts("haha");

        List<Post> posts1 = orderService.findPostsByAuthor(john);

        List<Comment> comments = orderService.findComments("aloalo");


        for (Post post : posts) {
            System.out.println("Post content: " + post.getContent());
        }

        System.out.println("Posts by jack: " + jack.getName());

        for (Post post : posts1) {
            System.out.println("Post content: " + post.getContent());
        }

        for (Comment commenttest : comments) {
            System.out.println("Comments found: " + commenttest.getId());
        }




    }

}
