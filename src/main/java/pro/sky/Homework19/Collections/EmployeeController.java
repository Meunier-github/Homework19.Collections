package pro.sky.Homework19.Collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeInterface EmployeeService;


    public EmployeeController(EmployeeInterface EmployeeService) {
        this.EmployeeService = EmployeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "firstName") String firstName,
                        @RequestParam(value = "lastName") String lastName,
                        @RequestParam(value = "secondName") String secondName) {

        return EmployeeService.add(firstName, lastName,secondName);

    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "lastName") String lastName,
                           @RequestParam(value = "secondName") String secondName) {
        return EmployeeService.remove(firstName, lastName,secondName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam(value = "firstName") String firstName,
                         @RequestParam(value = "lastName") String lastName,
                         @RequestParam(value = "secondName") String secondName) {

        return EmployeeService.find(firstName, lastName,secondName);
    }

    @GetMapping(path = "/print")
    public Collection<Employee> print() {
        return EmployeeService.print();
    }


}
