package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String videoLink;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "lesson")
    private List<Task> tasks;

    @ManyToOne(cascade = {DETACH,MERGE,REFRESH,PERSIST},fetch = FetchType.EAGER)
    private Course course;

    public Lesson(List<Task> tasks) {
        this.tasks = tasks;


}
    public Lesson (String name, String videoLink){
        this.name = name;
        this.videoLink = videoLink;
    }

    @Override
    public String toString() {
        return "\nLesson :" +
                "\nid :" + id +
                "\nname:" + name + "" +
                "\nvideoLink :" + videoLink + "" +
                "\ntasks :" + tasks +
                "\ncourse :" + course ;
    }
}
