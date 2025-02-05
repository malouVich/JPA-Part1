package app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Student extends Person {
    private int id;
    private String name;
    private int phone;
    private String email;
    private String address;
    private boolean status;
    private String dateOfBirth;
    private String dateOfEnrollment;

    public Student(String name, int age, int phone, String email, String address, boolean status, String dateOfBirth, String dateOfEnrollment)
    {
        super(name, age);
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEnrollment = dateOfEnrollment;
    }
}
