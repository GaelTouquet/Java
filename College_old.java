import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

abstract class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public double getSalary() {
        return salary;
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

class TeachingModule {
    Teacher teacher;
    Field field;
    Level level;
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Student> students = new ArrayList<Student>();

    public TeachingModule(Teacher teacher, Field field, Level level) {
        this.teacher = teacher;
        teacher.addTeachingModule(this);
        this.field = field;
        field.addTeachingModule(this);
        this.level = level;
        level.addTeachingModule(this);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Field getField() {
        return field;
    }

    public Level getLevel() {
        return level;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addGrade(Grade grade) {
        if (!this.grades.contains(grade))
            this.grades.add(grade);
    }

    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
            student.addTeachingModule(this);
        }
    }

}

class Teacher extends Staff {
    ArrayList<Field> fields = new ArrayList<Field>();
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Level> levels = new ArrayList<Level>();
    ArrayList<TeachingModule> teachingModules = new ArrayList<TeachingModule>();

    @Override
    public String toString() {
        List<String> fieldsNames = fields.stream().map(Field::getName).collect(Collectors.toList());
        return String.format("%s   fields : %s", super.toString(), String.join(",", fieldsNames));
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public Teacher(String name, double salary) {
        super(name, salary);
    }

    public void addField(Field field) {
        if (!this.fields.contains(field)) {
            this.fields.add(field);
            field.addTeacher(this);
        }
    }

    // TODO here addgrade can be used to mess up the system, a grade shouldn't be added to a teacher outside of friendly classes
    public void addGrade(Grade grade) {
        if (!this.grades.contains(grade))
            this.grades.add(grade);
    }

    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
            student.addTeacher(this);
        }
    }

    public ArrayList<TeachingModule> getTeachingModules() {
        return teachingModules;
    }

    public void addLevel(Level level) {
        if (!this.levels.contains(level)) {
            this.levels.add(level);
            level.addTeacher(this);
        }
    }

    public void addTeachingModule(TeachingModule teachingModule) {
        if (!this.teachingModules.contains(teachingModule))
            this.teachingModules.add(teachingModule);
        if (!this.fields.contains(teachingModule.getField()))
            this.addField(teachingModule.getField());
        if (!this.levels.contains(teachingModule.getLevel()))
            this.addLevel(teachingModule.getLevel());
        for (Student student : teachingModule.getStudents()) {
            if (!this.students.contains(student))
                this.addStudent(student);
        }
    }

    // TODO add remove student and grade and fields
}

class Student extends Person {
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Field> fields = new ArrayList<Field>();
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    ArrayList<TeachingModule> teachingModules = new ArrayList<TeachingModule>();
    Level level;

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public Level getLevel() {
        return level;
    }

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
        if (!this.fields.contains(field)) {
            this.fields.add(field);
            field.addStudent(this);
        }
    }

    public void addTeacher(Teacher teacher) {
        if (!this.teachers.contains(teacher)) {
            this.teachers.add(teacher);
            teacher.addStudent(this);
        }
    }

    public void addTeachingModule(TeachingModule teachingModule) {
        if (!this.teachingModules.contains(teachingModule)) {
            this.teachingModules.add(teachingModule);
            teachingModule.addStudent(this);
        }
    }

    public ArrayList<TeachingModule> getTeachingModules() {
        return teachingModules;
    }

    // TODO add remove teacher and grade and fields
}

class Level {
    String name;
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Field> fields = new ArrayList<Field>();
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<TeachingModule> teachingModules = new ArrayList<TeachingModule>();

    @Override
    public String toString() {
        return this.name;
    }

    public ArrayList<TeachingModule> getTeachingModules() {
        return teachingModules;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public Level(String name) {
        // TODO add name validity check
        this.name = name;
    }

    public void addTeacher(Teacher teacher) {
        if (!this.teachers.contains(teacher)) {
            this.teachers.add(teacher);
            teacher.addLevel(this);
        }
    }

    public void addStudent(Student student) {
        if (!this.students.contains(student))
            this.students.add(student);
    }

    public void addField(Field field) {
        if (!this.fields.contains(field)) {
            this.fields.add(field);
            field.addLevel(this);
        }
    }

    public void addGrade(Grade grade) {
        if (!this.grades.contains(grade))
            this.grades.add(grade);
    }

    public void addTeachingModule(TeachingModule teachingModule) {
        if (!this.teachingModules.contains(teachingModule))
            this.teachingModules.add(teachingModule);
    }

    // TODO add remove teacher and student and fields
}

class Field {
    String name;
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Level> levels = new ArrayList<Level>();
    ArrayList<TeachingModule> teachingModules = new ArrayList<TeachingModule>();

    public String getName() {
        return name;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

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

    public ArrayList<TeachingModule> getTeachingModules() {
        return teachingModules;
    }

    public void addTeachingModule(TeachingModule teachingModule) {
        if (!this.teachingModules.contains(teachingModule))
            this.teachingModules.add(teachingModule);
    }
}

class Grade {
    double grade;
    Teacher teacher;
    Student student;
    Field field;
    TeachingModule teachingModule;

    public double getGrade() {
        return grade;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student getStudent() {
        return student;
    }

    public Field getField() {
        return field;
    }

    public TeachingModule getTeachingModule() {
        return teachingModule;
    }

    @Override
    public String toString() {
        return String.format("grade : %2.2f   student : %s   field : %s   teacher : %s", this.grade, this.student.name,
                this.field.toString(), this.teacher.name);
    }

    public Grade(double grade, Student student, TeachingModule teachingModule) {
        this.grade = grade;
        this.teachingModule = teachingModule;
        this.teacher = this.teachingModule.teacher;
        teacher.addGrade(this);
        this.student = student;
        student.addGrade(this);
        this.field = teachingModule.field;
        field.addGrade(this);
    }
}

public class College_old {

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

    public void printGrades() {
        String output = "grades :\n";
        for (Grade grade : grades) {
            output += grade.toString() + "\n";
        }
        System.out.println(output);
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

    public College_old() {
    }

    public static void main(String[] args) {
        System.out.println("testing College:");

        College_old myCollege = new College_old();

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
        Teacher dupond = new Teacher("Dupond", 1400.37);
        myCollege.addPerson(dupond);
        Teacher isabelle = new Teacher("Isabelle", 1585.26);
        myCollege.addPerson(isabelle);
        // students
        Student billy = new Student("Billy", sixieme);
        myCollege.addPerson(billy);
        Student toto = new Student("Toto", troisieme);
        myCollege.addPerson(toto);

        // Teaching modules
        TeachingModule troisiemeAMaths = new TeachingModule(isabelle, maths, troisieme);
        TeachingModule troisiemeAAnglais = new TeachingModule(dupond, anglais, troisieme);
        TeachingModule sixiemeBFrancais = new TeachingModule(dupond, francais, sixieme);
        troisiemeAMaths.addStudent(toto);
        troisiemeAAnglais.addStudent(toto);
        sixiemeBFrancais.addStudent(billy);

        // Grades
        Grade math_toto = new Grade(12, toto, troisiemeAMaths);
        System.out.println(math_toto);
        Grade francais_billy = new Grade(8, billy, sixiemeBFrancais);
        System.out.println(francais_billy);
        Grade anglais_toto = new Grade(8, toto, troisiemeAAnglais);
        System.out.println(anglais_toto);

        // test teachers
        System.out.println("\nisabelle ne doit enseigner que les maths");
        System.out.println(isabelle);

        System.out.println("\ndupond enseigne le francais et l'anglais");
        System.err.println(dupond);

        // test students
        System.out.println("\ntoto a isabelle et dupond comme prof");
        System.out.println(toto);

        System.out.println("\nbilly n'a que dupond comme prof");
        System.out.println(billy);

        System.out.println(myCollege);

        myCollege.printGrades();
    }

}
