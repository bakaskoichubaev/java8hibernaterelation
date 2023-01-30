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
@Table(name = "Courses")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String duration;
    private String imageLink;
    private String description;

    private String createAt;

    @OneToMany(cascade = {ALL},fetch = FetchType.LAZY,mappedBy = "course")
    private List<Lesson>lessons = new ArrayList<>();

    @ManyToMany(cascade = {PERSIST,MERGE,DETACH,REFRESH},fetch = FetchType.EAGER)
    private List<Instructor> instructors = new ArrayList<>();

    public Course(String name, String duration, String imageLink, String description, String createAt) {
        this.name = name;
        this.duration = duration;
        this.imageLink = imageLink;
        this.description = description;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Course :" +
                "\nid :" + id +
                ", \nname :" + name + " "+
                ", \nduration:" + duration + "" +
                ", \nimageLink:" + imageLink +"" +
                ", \ndescription :" + description +"" +
                ", \ncreateAt :" + createAt + "" +
                ", \nlessons :" + lessons +
                ", \ninstructors :" + instructors ;
    }
}
