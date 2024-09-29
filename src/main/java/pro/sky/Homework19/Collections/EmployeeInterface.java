package pro.sky.Homework19.Collections;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface EmployeeInterface {
    Employee add(String firstName,String lastName,String secondName);

    Employee remove(String firstName,String lastName,String secondName);

    Employee find(String firstName,String lastName,String secondName);

    Collection<Employee> print();
}
