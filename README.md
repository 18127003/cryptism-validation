# cryptism-validation
A Framework to validate object in Java, which support direct validation handler, and also the convenient annotations. The framework use design patterns to support abstract management of validators to allow validation for nested objects and collections. It also allow creating and extending custom annotations.
There's also a Builder to support the construction of the validator to directly validate an object.
Demo using annotation and direct validator can be found at folder demo.

class Student implement Validatable {
  @MatchPattern(pattern = "^[a-zA-Z\\s]+$", message = "Name should be match the characters")
  @NotEmpty(message = "Name should not be empty")
  String name;

  @Max(value = 18, message = "Age must < 18")
  long age;

  @NotEmpty
  List<@NotNull Classroom> classrooms; 
}

student = new Student(...);
student.validate();

Detailed class diagram file can be found at class_diagram.pdf file.
Detailed design pattern implementation can be found at design_pattern.pdf file.
