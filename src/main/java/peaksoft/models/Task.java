package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String deadLine;
    private String task;

    @ManyToOne(cascade = {DETACH,MERGE,REFRESH,PERSIST},fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;


    public Task(String name, int deadLine, String task) {
        this.name = name;
        this.deadLine = String.valueOf(deadLine);
        this.task = task;
    }

    @Override
    public String toString() {
        return "\nTask :" +
                "\nid :" + id +
                "\nname :" + name + "" +
                "\ndeadLine :" + deadLine + "" +
                "\ntask :" + task + "" +
                "\nlesson :" + lesson ;
    }
}
