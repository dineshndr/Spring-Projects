
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Long.sum;


public class Main {
    public static void main(String[] args) {
    //Employee employee = new Employee();
    List<Employee> employees  = new ArrayList<>();
    employees.add(new Employee("Dinesh", 23000, List.of("one", "two")));
    employees.add(new Employee("suresh", 23300, List.of("one")));
    employees.add(new Employee("mahesh", 20000, List.of("one", "two")));


    //streams

//    List<Employee> li =
//             employees
//                .stream()
//                .collect(Collectors.toList());
//
//

        //Map
//        List<Employee> li =
//                employees
//                        .stream()
//                        .map(employee ->
//                                new Employee(employee.getFirstname() + "ndr", employee.getSalary(), employee.getProjects())).collect(Collectors.toList());


        //filter

//        List<Employee> filtered_employee =
//                employees
//                        .stream()
//                        .filter((employee -> (employee.getProjects().size()>1)))
//                        .limit(1)
//                                .collect(Collectors.toList());
//        System.out.println(filtered_employee);

        //flatmap = to extract the list of projects by sepearting with comma
//
//        {
//            String li =
//                    employees
//                            .stream()
//                            .map(employee -> employee.getProjects())
//                            .flatMap(strings -> strings.stream())
//                            .collect(Collectors.joining(","));
//        }

        //compareTo and sorted
//        List<Employee> li = employees
//                .stream()
//                        .sorted((o1, o2) -> o1.getFirstname().compareTo(o2.getFirstname())).collect(Collectors.toList());
//



        //Aggregation
        //min & max

//        Employee li  =
//                employees
//                        .stream()
//                                .min(((o1, o2) -> o1.getSalary()))
//                                        .orElse(null);


        Double sum = employees
                .stream()
                        .map(employee -> employee.getSalary())
                                .reduce(0, Integer::sum)
                .doubleValue();
        System.out.println(sum);
    }
}