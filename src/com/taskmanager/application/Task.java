package com.taskmanager.application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task 
{
	
	public static void addTask(Connection con, Scanner scn)
	{
		
		System.out.print("Enter task the title : ");
		scn.nextLine();
		String title=scn.nextLine();
		
		System.out.print("Enter the task  Description : ");
		String desc=scn.nextLine();
	
		System.out.print("Enter the task priority : ");
		String priority=scn.nextLine();
		
		System.out.print("Enter the task status : ");
		String status=scn.nextLine();
		
		String query="INSERT INTO TASKS(task_title,task_desc, task_priority, task_status) VALUES(?,?,?,?)";
		try 
		{
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, title);
			psmt.setString(2, desc);
			psmt.setString(3, priority);
			psmt.setString(4, status);
			psmt.execute();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		
		
	}
	public static void updateTask(Connection con, Scanner scn)
	{
		System.out.println("Enter the ID to Update :");
		int id=scn.nextInt();
		
		System.out.print("Enter task the title : ");
		scn.nextLine();
		String title=scn.nextLine();
		
		System.out.print("Enter the task  Description : ");
		String desc=scn.nextLine();
	
		System.out.print("Enter the task priority : ");
		String priority=scn.nextLine();
		
		System.out.print("Enter the task status : ");
		String status=scn.nextLine();
		String query="UPDATE  tasks SET TASK_TITLE=?, TASK_DESC=?, TASK_PRIORITY=?, TASK_STATUS=? WHERE task_ID=? ";
		try {
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, title);
			psmt.setString(2, desc);
			psmt.setString(3, priority);
			psmt.setString(4, status);
			psmt.setInt(5, id);
			psmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  void deleteTask(Connection con, Scanner scn) 
	{
		String query="DELETE FROM TASKS WHERE task_ID=?";
		System.out.println("Enter the ID : ");
		int id=scn.nextInt();
		try {
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1, id);
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void viewTask(Connection con, Scanner scn)
	{
		String query="SELECT * FROM TASKS";
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.print("Task ID : "+rs.getInt(1)+", ");
				System.out.print("Title : "+rs.getString(2)+", ");
				System.out.print("Description : "+rs.getString(3)+", ");
				System.out.print("Priority : "+rs.getString(4)+", ");
				System.out.print("Status : "+rs.getString(5));
				System.out.println();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void filterByPrioriy(Connection con, Scanner scn)
	{
		String query="SELECT * FROM TASKS WHERE TASK_PRIORITY=?";
		System.out.println("Enter the priority : ");
		String p=scn.next();
		
		
		PreparedStatement psmt;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, p);
			ResultSet rs=psmt.executeQuery();
			
			while(rs.next())
			{
				System.out.print("Task ID : "+rs.getInt(1)+", ");
				System.out.print("Title : "+rs.getString(2)+", ");
				System.out.print("Description : "+rs.getString(3)+", ");
				System.out.print("Priority : "+rs.getString(4)+", ");
				System.out.print("Status : "+rs.getString(5));
				System.out.println();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
