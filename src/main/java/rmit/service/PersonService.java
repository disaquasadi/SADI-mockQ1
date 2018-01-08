package rmit.service;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import rmit.entity.Course;
import rmit.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CoT on 10/13/17.
 */

@Transactional
public class PersonService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //generic
    public void save(Object object){
        sessionFactory.getCurrentSession().save(object);
    }


    public void savePerson(Person person){
        sessionFactory.getCurrentSession().save(person);
    }

    public List<Person> getAllPersons(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Person.class);
        return criteria.list();
    }

    public void deletePerson(Person person){
        sessionFactory.getCurrentSession().delete(person);
    }

    public Person getPersonById(int id){
        return (Person)sessionFactory.getCurrentSession().get(Person.class, id);
    }

    public List<Person> getPersonByName(String name){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Person.class);
        criteria.add(Restrictions.like("name",name, MatchMode.ANYWHERE));
        return criteria.list();
    }

    public List<Person> getPersonByName2(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from Person where name like :name");
        query.setString("name", "%"+name+"%");
        return query.list();
    }

    public List<Person> getPersonByName3(String name){
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from newperson");
        return query.list();
    }

    //courses
    public Course getCourseById(int id){
        return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
    }

}
