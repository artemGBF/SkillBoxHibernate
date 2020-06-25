package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(PurchaseTrans.PurchaseId.class)
@Table(name = "purchasetrans")
public class PurchaseTrans {
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    private int price;
    private String subscription_date;

    public PurchaseTrans() {
    }

    public PurchaseTrans(Student student, Course course, int price, String subscription_date) {
        this.student = student;
        this.course = course;
        this.price = price;
        this.subscription_date = subscription_date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSubscription_date() {
        return subscription_date;
    }

    public void setSubscription_date(String subscription_date) {
        this.subscription_date = subscription_date;
    }

    @Override
    public String toString() {
        return "PurchaseTrans{" +
                "student=" + student +
                ", course=" + course +
                ", price=" + price +
                ", subscription_date='" + subscription_date + '\'' +
                '}';
    }

    public static class PurchaseId implements Serializable {
        static final long serialVersionUID = 1L;
        private Student student;
        private Course course;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PurchaseId that = (PurchaseId) o;
            return Objects.equals(student, that.student) &&
                    Objects.equals(course, that.course);
        }

        @Override
        public int hashCode() {
            return Objects.hash(student, course);
        }

        @Override
        public String toString() {
            return "PurchaseId{" +
                    "student=" + student +
                    ", course=" + course +
                    '}';
        }
    }
}
