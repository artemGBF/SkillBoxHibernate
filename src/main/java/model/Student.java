package model;

import com.google.gson.Gson;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String registration_date;

    @OneToMany(mappedBy = "student")
    private List<Purchase> purchases;

    @OneToMany(mappedBy = "student")
    private List<PurchaseTrans> purchaseTrans;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subscriptions",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courses;

    public Student() {}

    public Student(Long id, String name, int age, String registration_date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.registration_date = registration_date;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public List<PurchaseTrans> getPurchaseTrans() {
        return purchaseTrans;
    }

    public void setPurchaseTrans(List<PurchaseTrans> purchaseTrans) {
        this.purchaseTrans = purchaseTrans;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", registration_date='" + registration_date + '\'' +
                '}';
    }
}
