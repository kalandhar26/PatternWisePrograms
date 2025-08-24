package altimetrik;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {
        // Product (name, category, salesUnit, costPerUnit)

        List<Product> products = Arrays.asList(
                new Product("Lux", "SOAP", 10, 5),
                new Product("Rexona", "SOAP", 15, 6),
                new Product("LifeBoy", "SOAP", 7, 3),

                new Product("Lux", "SOAP1", 10, 5),
                new Product("Rexona", "SOAP1", 15, 6),
                new Product("LifeBoy", "SOAP1", 7, 3),

                new Product("SOFA", "HOME", 11, 10),
                new Product("Cot", "HOME", 20, 15),
                new Product("TV", "HOME", 9, 8));


        Map<String, Double> map = products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(product -> product.getSalesUnit() * product.getCostPerUnit())));


        double secondHighest = map.entrySet().stream().sorted((value1, value2) -> (int) (value2.getValue() - value1.getValue())).mapToDouble(Map.Entry::getValue).skip(1).findFirst().orElseThrow();

        map.entrySet().stream().filter(entry -> entry.getValue() == secondHighest).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).forEach((k, v) -> System.out.println(k + " -> " + v));

        // Want Products whose Price is > 5
        products.stream().filter(product -> product.getCostPerUnit() > 5).map(Product::getName).distinct().forEach(System.out::println);

        double averagePrice = products.stream().collect(Collectors.averagingDouble(Product::getCostPerUnit));
        System.out.println(averagePrice);

        List<Student> students = getStudents();

        System.out.println("================= Top 3 Students =================");
        students.stream().sorted((s1, s2) -> Double.compare(s2.getSubject().stream().mapToInt(Subject::getMarks).sum(), s1.getSubject().stream().mapToInt(Subject::getMarks).sum())).limit(3).forEach(System.out::println);

        System.out.println("================= 2nd Rank Student =================");
        Map<Student, Double> studentMarksMap = students.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        student -> student.getSubject().stream().mapToDouble(Subject::getMarks).sum()
                ));
        double secondHighestMarks = studentMarksMap.values().stream().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(0.0);
        System.out.println(secondHighestMarks);

        studentMarksMap.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), secondHighestMarks)).forEach(entry -> System.out.println(entry.getKey().getFirstName() + " -> " + entry.getValue()));

        // Average Marks of entire class
        double classAverage = students.stream().flatMap(student -> student.getSubject().stream()).mapToDouble(Subject::getMarks).average().orElse(0.0);
        System.out.println("class Average: " + classAverage);

        // Each Student Average
        students.stream().collect(Collectors.toMap(Student::getFirstName, s -> s.getSubject().stream().mapToDouble(Subject::getMarks).average().orElse(0.0))).forEach((k, v) -> System.out.println(k + " -> " + v));

        // Subject Performace
        Map<Integer, Double> subjectWiseAvgMarks = students.stream().flatMap(subject -> subject.getSubject().stream()).collect(Collectors.groupingBy(Subject::getId, Collectors.averagingDouble(Subject::getMarks)));
        System.out.println("Subject Wise Average Marks");
        subjectWiseAvgMarks.forEach((k, v) -> System.out.println(k + " -> " + v));

        subjectWiseAvgMarks.entrySet().stream().sorted((m1, m2) -> Double.compare(m2.getValue(), m1.getValue())).forEach(System.out::println);

        // Sort based on FirstName and LastName
        students.stream().sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName).thenComparing(Student::getRollNumber)).forEach(System.out::println);
    }

    private static List<Student> getStudents() {
        List<Subject> subject1 = Arrays.asList(new Subject(90, 1), new Subject(36, 2), new Subject(29, 3));
        List<Subject> subject2 = Arrays.asList(new Subject(80, 1), new Subject(46, 2), new Subject(39, 3));
        List<Subject> subject3 = Arrays.asList(new Subject(70, 1), new Subject(56, 2), new Subject(69, 3));
        List<Subject> subject4 = Arrays.asList(new Subject(60, 1), new Subject(66, 2), new Subject(59, 3));
        List<Subject> subject5 = Arrays.asList(new Subject(50, 1), new Subject(76, 2), new Subject(89, 3));

        return Arrays.asList(
                new Student(1L, "baba1", "kala1", 10, subject1),
                new Student(2L, "baba2", "kala2", 20, subject2),
                new Student(3L, "baba3", "kala3", 30, subject3),
                new Student(4L, "baba4", "kala4", 40, subject4),
                new Student(5L, "baba5", "kala5", 50, subject5),
                new Student(6L, "baba6", "kala6", 60, subject2),
                new Student(7L, "baba7", "kala7", 70, subject3),
                new Student(8L, "baba8", "kala8", 80, subject5)
        );
    }


}
