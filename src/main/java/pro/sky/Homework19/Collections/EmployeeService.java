package pro.sky.Homework19.Collections;

import org.springframework.stereotype.Service;
import pro.sky.Homework19.Collections.Exception.EmployeeAlreadyAddedException;
import pro.sky.Homework19.Collections.Exception.EmployeeNotFoundException;
import pro.sky.Homework19.Collections.Exception.EmployeeStorageIsFullException;

import java.util.*;


@Service
public class EmployeeService implements EmployeeInterface {
    Map<String, Employee> employees = new HashMap<>();
    final int MAX_COUNT_EMPLOYEES = 5;

    public Employee add(String firstName, String lastName, String secondName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {

        if (employees.size() > MAX_COUNT_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName, secondName);
        if (employees.containsKey(employee.getFIO())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFIO(), employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName, String secondName) {


        Employee employee = new Employee(firstName, lastName, secondName);
        if (!employees.containsKey(employee.getFIO())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFIO());
        return employee;
    }

    public Employee find(String firstName, String lastName, String secondName) {
        Employee employee = new Employee(firstName, lastName, secondName);
        if (!employees.containsKey(employee.getFIO())) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> print() {
        return Collections.unmodifiableCollection(employees.values());
    }

}
