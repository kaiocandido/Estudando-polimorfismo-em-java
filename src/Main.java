import Entities.Employee;
import Entities.OutsourceEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Quantos funcionarios são: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Employee #" + (i + 1) + " data: ");
            System.out.print("Outsourced: (yes/no)? ");
            String option = sc.next();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double value = sc.nextDouble();

            if (option.equals("yes")){
                System.out.print("addional charge: ");
                double additional = sc.nextDouble();
                Employee emp = new OutsourceEmployee(name, hours, value, additional);
                list.add(emp);
            }else {
                Employee emp = new Employee(name, hours, value);
                list.add(emp);
            }

        }

        System.out.println();
        System.out.println("Payments: ");
        for (Employee a : list){
            System.out.println(a.getName() + " - $ " + String.format("%.2f", a.payment()));
        }
    }
}