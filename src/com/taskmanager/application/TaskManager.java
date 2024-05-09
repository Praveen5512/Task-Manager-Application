package com.taskmanager.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class TaskManager 
{
	public static void main(String[] args) 
	{
		String dburl="jdbc:mysql://localhost:3306/task_manager?user=root&password=root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=null;
		try {
			con=DriverManager.getConnection(dburl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner scn=new Scanner(System.in);
		while(true)
		{
			System.out.print("1.Add Task\n2.Edit Task\n3.Delete Task\n4.View Task\n5.Filter Tasks by Priority\n6.Exit");
			System.out.println();
			System.out.println("Enter the choice(1-6) : ");
			int choice=scn.nextInt();
			switch(choice)
			{
				case 1: Task.addTask(con, scn);
						break;
				case 2:Task.updateTask(con, scn);
				 		break;
				case 3:Task.deleteTask(con, scn);
						break;
				case 4:Task.viewTask(con, scn);;
				 		break;
				case 5 :Task.filterByPrioriy(con, scn);
						break;
				case 6: System.out.println("Application is exiting....");
						return;
				default:System.out.println("Invalid choice. Please make sure that you are entering the choice between 1-6");
				
			}
		}
	}
}
