package startApp;

import java.util.List;
import java.util.Scanner;

import database.DBWorker;
import model.Department;
import model.Lector;

public class App 
{
    public static void main( String[] args )
    {
        DBWorker dbWorker = new DBWorker();

        Scanner sc = new Scanner(System.in); 
        String command; 

        while (true) {
        	 command = sc.nextLine(); 
            if(command.contains("Who is head of department")) {
            	command = command.split(" ")[5];
            	dbWorker.getHeadDepartment(command);

            }else if(command.contains("Show the average salary for the department")) {
            	command = command.split(" ")[7];
            	dbWorker.getAverageSalary(command);
            }else if(command.contains("Show count of employee for")) {
            	command = command.split(" ")[5];
            	dbWorker.writeCountEmployeesByDepartmentName(command);
            }else if(command.contains("Show")&&command.contains("statistics")) {
            	command = command.split(" ")[1];
            	dbWorker.writeStatisticByDepartmentName(command);
            }else if(command.contains("Global search by")) {
            	command = command.split(" ")[3];
            	dbWorker.globalSearch(command);
            }else {
            	System.out.println("Command is unknown");
            	
            }

        }

    }
}
