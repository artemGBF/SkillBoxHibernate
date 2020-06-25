package program;

import DAO.DAO;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static List<PurchaseTrans> getPurchaseTrans() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernatemysql.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseTrans> criteria = builder.createQuery(PurchaseTrans.class);
        criteria.from(PurchaseTrans.class);
        List<PurchaseTrans> data = session.createQuery(criteria).getResultList();
        sessionFactory.close();
        return data;
    }

    public static List<Student> getStudents() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernatemysql.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        criteria.from(Student.class);
        return session.createQuery(criteria).getResultList();
    }

    public static List<Course> getCourses() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernatemysql.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> criteria = builder.createQuery(Course.class);
        criteria.from(Course.class);
        return session.createQuery(criteria).getResultList();
    }

    public static List<Teacher> getTeachers(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernatemysql.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteria = builder.createQuery(Teacher.class);
        criteria.from(Teacher.class);
        return session.createQuery(criteria).getResultList();
    }

    public static List<Purchase> getPurchaseList(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernatemysql.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Purchase> criteria = builder.createQuery(Purchase.class);
        criteria.from(Purchase.class);
        return session.createQuery(criteria).getResultList();
    }


    public static void main(String[] args) throws ParseException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernatemysql.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        /* System.out.println(data);
        for (int i = 0; i < data.size(); i++) {
            try {
                PurchaseTrans purchase = data.get(i);
                PurchaseTrans purchaseTrans = new PurchaseTrans(purchase.getStudent(), purchase.getCourse(),
                        purchase.getPrice(), purchase.getSubscription_date());
                session.beginTransaction();
                session.save(purchaseTrans);
                session.getTransaction().commit();
            } catch (PersistenceException e) {
            }
        }*/

        /*List<PurchaseTrans> purchaseTrans = getPurchaseTrans();
        System.out.println(purchaseTrans);*/
        /*List<Student> students = getStudents();
        System.out.println(students);
        for (int i = 0; i < students.size(); i++) {
            //System.out.println(students.get(i).getPurchases());
            System.out.println(students.get(i).getPurchaseTrans());
        }*/



        /*List<Course> courses = getCourses();
        System.out.println(courses);
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i).getPurchases());
            System.out.println(courses.get(i).getPurchaseTrans());
        }*/

        /*CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);
        query.select(root).where(builder.greaterThan(root.<Comparable>get("price"), 100000))
                .orderBy(builder.desc(root.get("price")));

        List<Course> resultList = session.createQuery(query).getResultList();
        System.out.println(resultList);*/

       /* List<Teacher> teachers = getTeachers();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = builder.createQuery(Teacher.class);
        Root<Teacher> root = query.from(Teacher.class);
        Predicate age1 = builder.greaterThan(root.<Comparable>get("age"), 19);
        Predicate age2 = builder.lessThan(root.<Comparable>get("age"), 21);
        Predicate ageAnd = builder.and(age2, age1);

        Predicate age = builder.between(root.<Comparable>get("age"), 19, 21);//инстанциирование
        Predicate salary = builder.greaterThan(root.<Comparable>get("salary"), 5000);
        query.select(root).where(builder.and(age, salary))
                .orderBy(builder.desc(root.get("salary")));
        List<Teacher> resultList = session.createQuery(query).getResultList();
        System.out.println(resultList);

        Predicate name = builder.like(root.<String>get("name"), "А%");
        query.select(root).where(name);
        List<Teacher> resultList1 = session.createQuery(query).getResultList();
        System.out.println(resultList1);*/

       /* List<Purchase> purchaseList = getPurchaseList();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Purchase> query = criteriaBuilder.createQuery(Purchase.class);
        Root<Purchase> root = query.from(Purchase.class);
        Predicate date = criteriaBuilder.greaterThan(root.<Comparable>get("subscription_date"),"2018.09.01");
        query.select(root).where(date);
        List<Purchase> resultList = session.createQuery(query).getResultList();
        System.out.println(resultList);*/


       /* Scanner s = new Scanner(System.in);
        String fio = s.nextLine();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query2 = criteriaBuilder.createQuery(Student.class);
        Root<Student> root2 = query2.from(Student.class);
        Predicate name = criteriaBuilder.equal(root2.<Comparable>get("name"),fio);
        query2.select(root2).where(name);
        List<Student> resultList1 = session.createQuery(query2).getResultList();

        CriteriaQuery<PurchaseTrans> query = criteriaBuilder.createQuery(PurchaseTrans.class);
        Root<PurchaseTrans> root = query.from(PurchaseTrans.class);
        Predicate date = criteriaBuilder.equal(root.<Comparable>get("student"),resultList1.get(0).getId());
        query.select(root).where(date).orderBy(criteriaBuilder.desc(root.get("subscription_date")));
        List<PurchaseTrans> resultList = session.createQuery(query).getResultList();
        System.out.println(resultList);*/


        /* List<Student> allObjects = (List<Student>) DAO.getAllObjects(Student.class);
        for (int i = 0; i < allObjects.size(); i++) {
            System.out.println(allObjects.get(i).getPurchaseTrans());
        }*/

        /*Course objectById = (Course) DAO.getObjectById(1L, Course.class);
        List<Student> students = objectById.getStudents();
        System.out.println(students);*/

        Student objectById = (Student)DAO.getObjectById(1L, Student.class);
        List<Course> courses = objectById.getCourses();
        System.out.println(courses);
    }
}