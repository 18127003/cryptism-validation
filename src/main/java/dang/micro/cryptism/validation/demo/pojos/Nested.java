package dang.micro.cryptism.validation.demo.pojos;

import dang.micro.cryptism.validation.annotations.Max;
import dang.micro.cryptism.validation.annotations.NotNull;
import dang.micro.cryptism.validation.validator.Validatable;

import java.util.List;

public class Nested implements Validatable {
    @NotNull
//    @Ignore
    private Student student;

    @Max(4)
    int value;

    public Nested(int value) {
        this.value = value;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
