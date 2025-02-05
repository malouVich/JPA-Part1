package app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Course {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String semester;
    private double classroom;
    private long minutes;

    public Course(String name, String semester, double classroom, long minutes) {
        this.name = name;
        this.semester = semester;
        this.classroom = classroom;
        this.minutes = minutes;
    }
}
