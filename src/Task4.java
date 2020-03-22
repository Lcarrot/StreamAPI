import java.util.*;
import java.util.stream.Stream;

public class Task4 {

    public static class ComparatorStudents implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getAverageMark() == o2.getAverageMark()) {
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getAverageMark() - o2.getAverageMark();
        }
    }

    public static class Student{

        private String name;
        private int averageMark;

        public Student(String name, int averageMark) {
            this.name = name;
            this.averageMark = averageMark;
        }

        public String getName() {
            return name;
        }

        public int getAverageMark() {
            return averageMark;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return averageMark == student.averageMark &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, averageMark);
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vanya", 56));
        students.add(new Student("Vasili", 56));
        students.add(new Student("Oleg", 90));
        students.add(new Student("Dmitri", 34));
        students.add(new Student("Andrey", 90));
        students.add(new Student("Andrey", 90));
        List<Student> newStudents = new ArrayList<>();
        newStudents.add(new Student("Vanya", 56));
        newStudents.add(new Student("Vasili", 2));
        newStudents.add(new Student("Alex", 90));
        newStudents.add(new Student("Dmitri", 89));
        newStudents.add(new Student("Andrey", 360));
        newStudents.add(new Student("Andrey", 360));
        newStudents.add(new Student("Oleg", 360));
        Comparator<Student> comparator = new ComparatorStudents();
        Stream<Student> stream = students.stream();
        stream.distinct().sorted(comparator).
                forEach(student -> System.out.println(student.getName() + " " + student.getAverageMark()));
        System.out.println("-------------------------------------------------------------------------------");
        Stream<Student> studentStream = students.stream();
        Stream<Student> stream1 = newStudents.stream();
        Student bigger = studentStream.max(comparator).get();
        stream1.filter(student -> comparator.compare(student, bigger) > 0).distinct().
                forEach(student -> System.out.println(student.getName() + " " +student.getAverageMark()));
        System.out.println("-------------------------------------------------------------------------------");
        Map<String, String> map = new HashMap<>();
        map.put("dadaya", "ofo");
        map.put("zheka", "korzheka");
        Stream<String> stream2 = map.keySet().stream();
        StringBuffer string = new StringBuffer();
        stream2.distinct().forEach(string::append);
        System.out.println(string);
    }
}
