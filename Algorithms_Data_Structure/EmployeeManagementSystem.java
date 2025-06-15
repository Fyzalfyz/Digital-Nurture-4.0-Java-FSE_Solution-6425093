/**
 *
 * @author Fyzal
 */
class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {
        System.out.println(employeeId + " - " + name + " - " + position + " - Rs." + salary);
    }
}

public class EmployeeManagementSystem {
    static Employee[] employees = new Employee[10];
    static int count = 0;

    static void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
        }
    }

    static void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    static void searchEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(id)) {
                employees[i].display();
                return;
            }
        }
        System.out.println("Employee not found");
    }

    static void deleteEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                return;
            }
        }
        System.out.println("Employee not found to delete");
    }

    public static void main(String[] args) {
        addEmployee(new Employee("E001", "Fyzal", "Developer", 50000));
        addEmployee(new Employee("E002", "Kiran", "Tester", 42000));
        addEmployee(new Employee("E003", "Fazil", "Support", 38000));
        addEmployee(new Employee("E004", "Arun", "HR", 46000));
        addEmployee(new Employee("E005", "Yokes", "Designer", 49000));

        System.out.println("All Employees:");
        traverseEmployees();

        System.out.println("\nSearching for E003:");
        searchEmployee("E003");

        System.out.println("\nDeleting E002:");
        deleteEmployee("E002");

        System.out.println("\nEmployees after deletion:");
        traverseEmployees();
    }
}

