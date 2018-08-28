package streams;

import lombok.SneakyThrows;
import org.mockito.cglib.core.Local;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {

    @SneakyThrows
    public static void main1(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\GP\\Desktop\\basicjava-deutsche-2018-7a1ff663de220e6ae27e1dfa0a8bf9ede87cebdd\\src\\main\\java\\hamlet.txt"));
        Map<String, Integer> collect = bufferedReader.lines().map(String::toLowerCase)
                .flatMap((line) -> Stream.of(line.split("\\W+")))
                .collect(groupingBy(Function.identity(), summingInt(e -> 1)));
    }

    @SneakyThrows
    public static void main2(String[] args) {
        Stream<Employee> employeeStream = Stream.of(new Employee("A", 1, "LOW_INC"), new Employee("B", 2, "LOW_INC"),
                new Employee("C", 3, "MID_INC"), new Employee("D", 4, "MID_INC"),
                new Employee("E", 5, "HIGH_INC"), new Employee("F", 5, "HIGH_INC"));


        Map<String, Double> collect = employeeStream.collect(Collectors.groupingBy(Employee::getCompanyName, averagingDouble(Employee::getSalary)));
        System.out.println(collect);
    }

    @SneakyThrows
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(1980, 12, 23);
        getFridays(of, now);
    }

    static void getFridays(LocalDate date1, LocalDate date2){

        long numOfDaysBetween = ChronoUnit.DAYS.between(date1, date2);
        List<LocalDate> collect = IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(date1::plusDays).collect(Collectors.toList());
        List<LocalDate> collect1 = collect.stream().filter(localDate -> localDate.getDayOfWeek() == DayOfWeek.FRIDAY).filter(localDate -> localDate.getDayOfMonth() == 13).collect(Collectors.toList());
        Map<Integer, Long> collect2 = collect1.stream().collect(Collectors.groupingBy(LocalDate::getYear, counting()));

        System.out.println(collect2);


    }
}
