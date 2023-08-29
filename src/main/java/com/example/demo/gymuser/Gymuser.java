package com.example.demo.gymuser;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "gym-user")
public class Gymuser {
    @Id
    @SequenceGenerator(
            name = "sequence_gymuser",
            sequenceName = "sequence_gymuser",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_gymuser"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer daysAllowed;
    @Transient
    private Integer age;

    public Gymuser() {

    }

    public Gymuser(String name,
                   String email,
                   LocalDate dob,
                   Integer daysAllowed) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.daysAllowed = daysAllowed;
    }

    public Gymuser(Long id,
                   String name,
                   String email, LocalDate dob,
                   Integer daysAllowed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.daysAllowed = daysAllowed;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getDaysAllowed() {
        return daysAllowed;
    }

    public void setDaysAllowed(Integer daysAllowed) {
        this.daysAllowed = daysAllowed;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "gymuser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", daysAllowed=" + daysAllowed +
                ", age=" + age +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
