package demo.test1.model;

import org.springframework.stereotype.Service;

@Service

public class Employee {
    int id=1;
    int salary =10000;
    public Employee(){
    }

    public int get_salary(int id){
        if(this.id == id){
            System.out.println("Employee salary is"+this.salary);
            return this.salary;
        }
        else{
            System.out.println("No emp found");
            return 0;
        }
    }
}
