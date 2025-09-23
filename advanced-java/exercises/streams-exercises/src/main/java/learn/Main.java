package learn;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        StudentDataStore ds = new StudentDataStore();
        List<Student> students = ds.all();

        // 0. Print all students
        // iteration solution
        for (Student student : students) {
            System.out.println(student);
        }

        // stream solution
        students.stream().forEach(System.out::println);

        // 1. Print students from Argentina
        System.out.println("// 1. Print students from Argentina");
        students.stream()
                .filter(a -> a.getCountry().equalsIgnoreCase("Argentina"))
                .forEach(System.out::println);

        // 2. Print students whose last names starts with 'T'.
        System.out.println("// 2. Print students whose last names starts with 'T'.");
        students.stream()
                .filter(a -> a.getLastName().startsWith("T"))
                .forEach(System.out::println);

        // 3. Print students from Argentina, ordered by GPA
        System.out.println("// 3. Print students from Argentina, ordered by GPA");
        students.stream()
                .filter(a -> a.getCountry().equalsIgnoreCase("Argentina"))
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .forEach(System.out::println);

        // 4. Print the bottom 10% (100 students) ranked by GPA.
        System.out.println("// 4. Print the bottom 10% (100 students) ranked by GPA.");
        students.stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .limit(students.size() / 10)
                .forEach(System.out::println);

        // 5. Print the 4th - 6th ranked students by GPA from Argentina
        System.out.println("// 5. Print the 4th - 6th ranked students by GPA from Argentina");
        students.stream()
                .filter(a -> a.getCountry().equalsIgnoreCase("Argentina"))
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .skip(4)
                .limit(3)
                .forEach(System.out::println);

        // 6. Is anyone from Maldives?
        System.out.println("// 6. Is anyone from Maldives?");
        boolean hasMaldivesResidents = students.stream()
                .anyMatch(a -> a.getCountry().equalsIgnoreCase("Maldives"));
        System.out.println(hasMaldivesResidents ? "Yes" : "No");

        // 7. Does everyone have a non-null, non-empty email address?
        System.out.println("// 7. Does everyone have a non-null, non-empty email address?");
        boolean allHaveEmail = students.stream()
                .allMatch(a -> a.getEmailAddress() != null && !a.getEmailAddress().isEmpty());
        System.out.println(allHaveEmail ? "Yes" : "No");

        // 8. Print students who are currently registered for 5 courses.
        System.out.println("// 8. Print students who are currently registered for 5 courses.");
        students.stream()
                .filter(a -> a.getRegistrations().size() == 5)
                .forEach(System.out::println);

        // 9. Print students who are registered for the course "Literary Genres".
        System.out.println("// 9. Print students who are registered for the course \"Literary Genres\".");
        students.stream()
                .filter(student -> student.getRegistrations()
                        .stream()
                        .anyMatch(r -> r.getCourse().equalsIgnoreCase("Literary Genres"))
                ).forEach(System.out::println);


        // 10. Who has the latest birthday? Who is the youngest?
        System.out.println("// 10. Who has the latest birthday? Who is the youngest?");
        students.stream()
                .max(Comparator.comparing(Student::getBirthDate))
                .ifPresent(System.out::println);

        // 11. Who has the highest GPA? There may be a tie.
        System.out.println("// 11. Who has the highest GPA? There may be a tie.");
        BigDecimal highestGPA = students.stream()
                .map(Student::getGpa)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        students.stream()
                .filter(s -> s.getGpa().compareTo(highestGPA) == 0)
                .forEach(System.out::println);


        // 12. Print every course students are registered for, including repeats.
        System.out.println("// 12. Print every course students are registered for, including repeats.");
        students.stream()
                .map(Student::getRegistrations)
                .flatMap(List::stream)
                .map(Registration::getCourse)
                .forEach(System.out::println);

        // 13. Print a distinct list of courses students are registered for.
        System.out.println("// 13. Print a distinct list of courses students are registered for.");
        students.stream()
                .map(Student::getRegistrations)
                .flatMap(List::stream)
                .map(Registration::getCourse)
                .distinct()
                .forEach(System.out::println);

        // 14. Print a distinct list of courses students are registered for, ordered by name.
        System.out.println("// 14. Print a distinct list of courses students are registered for, ordered by name.");
        students.stream()
                .map(Student::getRegistrations)
                .flatMap(List::stream)
                .map(Registration::getCourse)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // 15. Count students per country.
        System.out.println("// 15. Count students per country.");
        Map<String, Long> studentsPerCountry = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCountry,
                        Collectors.counting()
                ));
        studentsPerCountry.forEach((country, count) -> System.out.println(country + ": " + count));

        // 16. Count students per country. Order by most to fewest students.
        System.out.println("// 16. Count students per country. Order by most to fewest students.");
        studentsPerCountry.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // 17. Count registrations per course.
        System.out.println("// 17. Count registrations per course.");
        Map<String, Long> registrationsPerCourse = students.stream()
                .map(Student::getRegistrations)
                .flatMap(List::stream)
                .map(Registration::getCourse)
                .collect(Collectors.groupingBy(
                        course -> course,
                        Collectors.counting()
                ));
        registrationsPerCourse.forEach((course, count) -> System.out.println(course + ": " + count));

        // 18. How many registrations are not graded (GradeType == AUDIT)?
        System.out.println("// 18. How many registrations are not graded (GradeType == AUDIT)?");
        long auditCount = students.stream()
                .map(Student::getRegistrations)
                .flatMap(List::stream)
                .filter(r -> r.getGradType() == GradeType.AUDIT)
                .count();
        System.out.println("AUDIT registrations: " + auditCount);


        // 19. Create a new type, StudentSummary with fields for Country, Major, and IQ.
        //     Map Students to StudentSummary, then sort and limit by IQ (your choice of low or high).
        System.out.println("// 19. Create a new type, StudentSummary with fields for Country, Major, and IQ.");
        System.out.println("//     Map Students to StudentSummary, then sort and limit by IQ (your choice of low or high).");
        List<StudentSummary> topIqSummaries = students.stream()
                .map(s -> new StudentSummary(
                        s.getCountry(),
                        s.getMajor(),
                        s.getIq()
                ))
                .sorted(Comparator.comparing(StudentSummary::getIq).reversed())
                .limit(10)
                .toList();

        topIqSummaries.forEach(System.out::println);

        // 20. What is the average GPA per country (remember, it's random fictional data).
        System.out.println("// 20. What is the average GPA per country (remember, it's random fictional data).");
        Map<String, Double> averageGpaByCountry = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCountry,
                        Collectors.averagingDouble(s -> s.getGpa().doubleValue())
                ));
        averageGpaByCountry.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // 21. What is the maximum GPA per country?
        System.out.println("// 21. What is the maximum GPA per country?");
        Map<String, Optional<BigDecimal>> maxGpaPerCountry = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCountry,
                        Collectors.mapping(
                                Student::getGpa,
                                Collectors.maxBy(BigDecimal::compareTo)
                        )
                ));
        maxGpaPerCountry.forEach((country, maxGpa) ->
                System.out.println(country + ": " + maxGpa.orElse(BigDecimal.ZERO)));

        // 22. Print average IQ per Major ordered by IQ ascending.
        System.out.println("// 22. Print average IQ per Major ordered by IQ ascending.");
        Map<String, Double> avgIqPerMajor = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getMajor,
                        Collectors.averagingDouble(Student::getIq)
                ));

        avgIqPerMajor.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // 23. STRETCH GOAL!
        // Who has the highest pointPercent in "Sacred Writing"?
        System.out.println("// Who has the highest pointPercent in \"Sacred Writing\"?");
        Optional<Student> topStudent = students.stream()
                .filter(s -> s.getRegistrations().stream()
                        .anyMatch(r -> r.getCourse().equalsIgnoreCase("Sacred Writing")))
                .max(Comparator.comparing(s -> s.getRegistrations().stream()
                        .filter(r -> r.getCourse().equalsIgnoreCase("Sacred Writing"))
                        .map(Registration::getPointPercent)
                        .max(Double::compareTo)
                        .orElse(0.0)
                ));

        topStudent.ifPresent(System.out::println);
    }
}
