package dang.micro.cryptism.validation.demo.pojos;

import dang.micro.cryptism.validation.validator.Validatable;

import java.util.ArrayList;
import java.util.Collection;

public class Data implements Validatable {
//    @ArrayNotEmpty(message = "StudentData should not be empty")
    Collection<Student> students = new ArrayList<>();

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
}
