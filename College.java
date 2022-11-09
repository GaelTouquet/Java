import java.util.ArrayList;

abstract class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("name : %s", this.name);
    }
}

abstract class Staff extends Person {

    double salary;

    public Staff(String name, double salary) {
        super(name);
        // TODO add salary validity check
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s    salary : %.2f", super.toString(), this.salary);
    }
}

class Volunteer extends Person {
    public Volunteer(String name) {
        super(name);
    }
}

abstract class AdministrativeStaff extends Staff {
    public AdministrativeStaff(String name, double salary) {
        super(name, salary);
    }
}

class Secretary extends AdministrativeStaff {
    public Secretary(String name, double salary) {
        super(name, salary);
    }
}

class Teacher extends Staff {
    Field field; // TODO check with client, can a teacher teach different fields?
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Level> levels = new ArrayList<Level>();

    @Override
    public String toString() {
        return String.format("%s   field : %s", super.toString(), this.field.toString());
    }

    public Teacher(String name, double salary, Field field) {
        super(name, salary);
        this.field = field;
        field.addTeacher(this);
    }

    public void addGrade(Grade grade) {
        if (!this.grades.contains(grade))
            this.grades.add(grade);
    }

    public void addStudent(Student student) {
        if (!this.students.contains(student))
            this.students.add(student);
    }

    public void addLevel(Level level) {
        if (!this.levels.contains(level))
            this.levels.add(level);
    }

    // TODO add remove student and grade and fields
}

class Student extends Person {
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Field> fields = new ArrayList<Field>();
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    Level level;

    public double mean() {
        double output = 0;
        for (Grade grade : this.grades) {
            output += grade.grade;
        }
        output /= this.grades.size();
        return output;
    }

    @Override
    public String toString() {
        return String.format("%s   mean : %2.2f", super.toString(), this.mean());
    }

    public void setLevel(Level level) {
        this.level = level;
        level.addStudent(this);
    }

    public Student(String name, Level level) {
        super(name);
        this.setLevel(level);
    }

    public void addGrade(Grade grade) {
        if (!this.grades.contains(grade))
            this.grades.add(grade);
    }

    public void addField(Field field) {
        if (!this.fields.contains(field))
            this.fields.add(field);
    }

    public void addTeacher(Teacher teacher) {
        if (!this.teachers.contains(teacher))
            this.teachers.add(teacher);
    }

    // TODO add remove teacher and grade and fields
}

class Level {
    String name;
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Field> fields = new ArrayList<Field>();
    ArrayList<Grade> grades = new ArrayList<Grade>();

    @Override
    public String toString() {
        return this.name;
    }

    public Level(String name) {
        // TODO add name validity check
        this.name = name;
    }

    public void addTeacher(Teacher teacher) {
        if (!this.teachers.contains(teacher))
            this.teachers.add(teacher);
    }

    public void addStudent(Student student) {
        if (!this.students.contains(student))
            this.students.add(student);
    }

    public void addField(Field field) {
        if (!this.fields.contains(field))
            this.fields.add(field);
    }

    public void addGrade(Grade grade) {
        if (!this.grades.contains(grade))
            this.grades.add(grade);
    }

    // TODO add remove teacher and student and fields
}

class Field {
    String name;
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Level> levels = new ArrayList<Level>();

    public Field(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addTeacher(Teacher teacher) {
        if (!this.teachers.contains(teacher))
            this.teachers.add(teacher);
    }
    // TODO add remove teacher

    public void addStudent(Student student) {
        if (!this.students.contains(student))
            this.students.add(student);
    }
    // TODO add remove student

    public void addGrade(Grade grade) {
        if (!this.grades.contains(grade))
            this.grades.add(grade);
    }

    public void addLevel(Level level) {
        if (!this.levels.contains(level))
            this.levels.add(level);
    }
}

class Grade {
    double grade;
    Teacher teacher;
    Student student;
    Field field;

    @Override
    public String toString() {
        return String.format("grade : %2.2f   student : %s   field : %s   teacher : %s", this.grade, this.student.name,
                this.field.toString(), this.teacher.name);
    }

    public Grade(double grade, Teacher teacher, Student student) {
        this.grade = grade;
        this.teacher = teacher;
        teacher.addGrade(this);
        this.student = student;
        student.addGrade(this);
        this.field = teacher.field;
        teacher.field.addGrade(this);
    }
}

public class College {

    ArrayList<Person> persons = new ArrayList<Person>();
    ArrayList<Grade> grades = new ArrayList<Grade>();

    public void addPerson(Person person) {
        if (!this.persons.contains(person))
            this.persons.add(person);
    }

    public void addGrade(Grade grade) {
        if (!this.grades.contains(grade))
            this.grades.add(grade);
    }

    // TODO add get method with instance type? or with type name
    public ArrayList<Student> getStudents() {
        ArrayList<Student> output = new ArrayList<Student>();
        for (Person person : this.persons) {
            if (person instanceof Student) {
                output.add((Student) person);
            }
        }
        return output;
    }

    public ArrayList<Staff> getStaff() {
        ArrayList<Staff> output = new ArrayList<Staff>();
        for (Person person : this.persons) {
            if (person instanceof Staff) {
                output.add((Staff) person);
            }
        }
        return output;
    }

    public ArrayList<Teacher> getTeachers() {
        ArrayList<Teacher> output = new ArrayList<Teacher>();
        for (Person person : this.persons) {
            if (person instanceof Teacher) {
                output.add((Teacher) person);
            }
        }
        return output;
    }

    @Override
    public String toString() {
        String output = "";
        output += "staff:\n";
        // output += String.join(" \n", getStaff());
        for (Staff staff : this.getStaff()) {
            output += "   " + staff + "\n";
        }
        output += "students:\n";
        for (Student student : this.getStudents()) {
            output += "   " + student + "\n";
        }
        return output;
    }

    public College() {
    }

    public static void main(String[] args) {
        College myCollege = new College();

        // non teaching staff
        Secretary michel = new Secretary("michel", 1258.35);
        myCollege.addPerson(michel);

        // levels
        Level sixieme = new Level("6e");
        Level cinquieme = new Level("5e");
        Level quatrieme = new Level("4e");
        Level troisieme = new Level("3e");
        // fields
        Field maths = new Field("maths");
        Field francais = new Field("francais");
        Field anglais = new Field("anglais");
        // teachers
        Teacher dupond = new Teacher("Dupond", 1400.37, anglais);
        myCollege.addPerson(dupond);
        Teacher isabelle = new Teacher("Isabelle", 1585.26, maths);
        myCollege.addPerson(isabelle);
        // students
        Student billy = new Student("Billy", sixieme);
        myCollege.addPerson(billy);
        Student toto = new Student("Toto", troisieme);
        myCollege.addPerson(toto);

        // Grades
        Grade math_billy_october = new Grade(12, isabelle, billy);
        myCollege.addGrade(math_billy_october);

        System.out.println(myCollege);

        System.out.println(math_billy_october);
    }

}
