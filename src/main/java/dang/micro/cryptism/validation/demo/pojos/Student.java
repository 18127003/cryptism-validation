package dang.micro.cryptism.validation.demo.pojos;

import dang.micro.cryptism.validation.annotations.*;
import dang.micro.cryptism.validation.validator.Validatable;

import java.time.LocalDate;

public class Student implements Validatable {
    @MatchPattern(pattern = "^[a-zA-Z\\s]+$", message = "Name should be match the characters")
    @NotEmpty(message = "Name should not be empty")
    String name;

    @Email
    @NotEmpty(message = "Email should not be empty")
    @Length(max = 4, message = "Email length should has less than 4 characters")
    String email;

    @Max(value = 18, message = "Age must < 18")
    long age;

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

}
