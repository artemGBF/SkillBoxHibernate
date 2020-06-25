package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(Subscription.SubId.class)
@Table(name = "subscriptions")
public class Subscription implements Serializable {
    @Id
    @JoinColumn(name = "student_id")
    private Student student;
    @Id
    @JoinColumn(name = "course_id")
    private Course course;

    private Date subscription_date;

    public Subscription() {
    }

    public Subscription(Student student, Course course, Date subscription_date) {
        this.student = student;
        this.course = course;
        this.subscription_date = subscription_date;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "student=" + student +
                ", course=" + course +
                ", subscription_date=" + subscription_date +
                '}';
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

    public Date getSubscription_date() {
        return subscription_date;
    }

    public void setSubscription_date(Date subscription_date) {
        this.subscription_date = subscription_date;
    }

    public static class SubId implements Serializable {
        static final long serialVersionUID = 1L;
        private Student student;
        private Course course;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SubId subId = (SubId) o;
            return Objects.equals(student, subId.student) &&
                    Objects.equals(course, subId.course);
        }

        @Override
        public int hashCode() {
            return Objects.hash(student, course);
        }

        @Override
        public String toString() {
            return "SubId{" +
                    "student=" + student +
                    ", course=" + course +
                    '}';
        }
    }
}
