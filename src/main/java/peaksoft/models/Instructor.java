package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @ManyToMany(cascade = {DETACH, MERGE,REFRESH,PERSIST},fetch = FetchType.EAGER)
    @JoinTable(name = "instuctor_course",joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> course = new ArrayList<>();

    public Instructor(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\nInstructor :" +
                "\nid :" + id +
                ", \nfirstName :" + firstName + "" +
                ", \nlastName :" + lastName + "" +
                ", \nemail :" + email + "" +
                ", \nphoneNumber :" + phoneNumber + "" +
                ", \ncourse :" + course ;
    }
}
