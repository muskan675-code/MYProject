import java.util.*;

class Employee{
    int id;
    String name, department, project;

    Employee(int id, String name, String department, String project) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.project = project;
    }

    void display() {
        System.out.println(id + " " + name + " " + department + " " + project);
    }
}

public class EmployeManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. ArrayList
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(101, "Rahul", "Java", "Banking"));
        list.add(new Employee(102, "Priya", "Testing", "Insurance"));
        list.add(new Employee(103, "Amit", "Java", "Banking"));
        list.add(new Employee(104, "Sneha", "HR", "Management"));
        list.add(new Employee(105, "Rohit", "Testing", "Banking"));
        list.add(new Employee(106, "Neha", "Java", "Insurance"));
        list.add(new Employee(107, "Karan", "Cloud", "E-Commerce"));
        list.add(new Employee(108, "Anjali", "Java", "Banking"));

        // 2. HashMap
        HashMap<String, List<Employee>> map = new HashMap<>();

        // 3. HashSet
        HashSet<String> set = new HashSet<>();

        for (Employee e : list) {
            set.add(e.department);

            map.putIfAbsent(e.project, new ArrayList<>());
            map.get(e.project).add(e);
        }

        int choice;

        do {
            System.out.println("\n1. All Employees");
            System.out.println("2. Project Wise Employees");
            System.out.println("3. Unique Departments");
            System.out.println("4. Java Employees");
            System.out.println("5. Search Employee");
            System.out.println("6. Project Statistics");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Employee e : list) {
                        e.display();
                    }
                    break;

                case 2:
                    for (String p : map.keySet()) {
                        System.out.println("\nProject: " + p);

                        for (Employee e : map.get(p)) {
                            System.out.println(e.name);
                        }
                    }
                    break;

                case 3:
                    System.out.println(set);
                    break;

                case 4:
                    Iterator<Employee> it = list.iterator();

                    while (it.hasNext()) {
                        Employee e = it.next();

                        if (e.department.equals("Java")) {
                            e.display();
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    boolean found = false;

                    for (Employee e : list) {
                        if (e.id == id) {
                            e.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee not found");
                    }
                    break;

                case 6:
                    for (String p : map.keySet()) {
                        System.out.println(p + " = " + map.get(p).size());
                    }
                    break;

                case 7:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 7);

        sc.close();
    }
}