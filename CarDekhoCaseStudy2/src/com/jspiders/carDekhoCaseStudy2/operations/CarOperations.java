package com.jspiders.carDekhoCaseStudy2.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jspiders.carDekhoCaseStudy2.methods.CarDekhoMainMenu;


//create table car(id int primary key,name varchar(45) not null,brand varchar(45) not null,color varchar(45),fuelType varchar(45)
//not null ,price float not null


//import com.jspiders.carDekhoCaseStudy2.entity.Car;
//import com.jspiders.carDekhoCaseStudy2.methods.CarDekhoMainMenu;

public class CarOperations {
        private static Connection connection;
        private static PreparedStatement preparedStatement;
        private static ResultSet resultSet;
        private static String query;
        
//        static Scanner scanner=new Scanner(System.in);
        private static void openConnection() throws SQLException {
   		 connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "mansi@123");
   	 }
   	 private static void closeConnection() throws SQLException {
   		 if(preparedStatement != null) {
   			 preparedStatement.close();
   		 }
   		 if(connection != null) {
   			 connection.close();
   		 }
   		 if(resultSet != null) {
   			 resultSet.close();
   		 }
   	 }
        
        public void allCars() {
        	try {
				openConnection();
				System.out.println(" Details of all cars");
				query="SELECT * FROM car";
				preparedStatement=connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					   System.out.print(resultSet.getInt(1)+" | ");
	   	    		   System.out.print(resultSet.getString(2)+" | ");
	   	    		   System.out.print(resultSet.getString(3)+" | ");
	   	    		   System.out.print(resultSet.getString(4)+" | ");
	   	    		   System.out.print(resultSet.getString(5)+" | ");
	   	    		   System.out.println(resultSet.getString(6)+" | ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
        }
        public void addCar(Scanner scanner) {
        	try {
				openConnection();
				query="INSERT INTO car values(?,?,?,?,?,?)";
				preparedStatement=connection.prepareStatement(query);
				System.out.println("How many cars do you want to add");
				int num=scanner.nextInt();
				for (int i=1;i<=num;i++) {
					System.out.println("Enter id ");
					int id=scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter name ");
					String name=scanner.nextLine();
					System.out.println("Enter color ");
					String color=scanner.nextLine();
					System.out.println("Enter Brand ");
					String brand=scanner.nextLine();
					System.out.println("Enter fuelType ");
					String fuelType=scanner.nextLine();
					System.out.println("Enter Price ");
					float price= scanner.nextFloat();
					
					preparedStatement.setInt(1, id);
					preparedStatement.setString(2, name);
					preparedStatement.setString(3, brand);
					preparedStatement.setString(4, fuelType);
					preparedStatement.setString(5, color);
					preparedStatement.setFloat(6, price);
					
				    preparedStatement.addBatch();
				}
//				scanner.close();
				preparedStatement.executeBatch();
				System.out.println("data inserted");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
        }
        
        public void removeCar(Scanner scanner) {
        	try {
				openConnection();
				System.out.println("Enter id to Remove a car ");
				int id= scanner.nextInt();
				query="DELETE FROM user WHERE id= ? ";
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
				System.out.println("Car removed");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
        }
        
        public void updateCar(Scanner scanner){
        	try {
				openConnection();
				System.out.println("Enter id to Update car Price");
				int id=scanner.nextInt();
				System.out.println("enter new price ");
				float price=scanner.nextFloat();
			
//				scanner.close();
				
				query="UPDATE car SET price= ? WHERE id= ? ";
				preparedStatement= connection.prepareStatement(query);
				preparedStatement.setFloat(1, price);
				preparedStatement.setInt(2, id);
				preparedStatement.executeUpdate();
				System.out.println("Price updated");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
        }
        
        
       public void searchCarById(Scanner scanner){
    	  try {
			openConnection();
			 System.out.println("Enter id to view car");
			int id=scanner.nextInt();
	    	   query="SELECT * FROM car WHERE id=? ";
	    	   preparedStatement=connection.prepareStatement(query);
	    	   preparedStatement.setInt(1, id);
	    	   resultSet =preparedStatement.executeQuery();
	    	   if(resultSet.next()) {
	    		   System.out.print(resultSet.getInt(1)+" | ");
   	    		   System.out.print(resultSet.getString(2)+" | ");
   	    		   System.out.print(resultSet.getString(3)+" | ");
   	    		   System.out.print(resultSet.getString(4)+" | ");
   	    		   System.out.print(resultSet.getString(5)+" | ");
   	    		   System.out.println(resultSet.getString(6)+" | ");
	    		   
	    	   }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
       }
       public void  searchCarByName(Scanner scanner) throws SQLException {
    	   try {
			openConnection();
			System.out.println("Enter name to view car");
			scanner.nextLine();
	    	   String name=scanner.nextLine();
	    	   query="SELECT * FROM car WHERE name=? ";
	    	   preparedStatement=connection.prepareStatement(query);
	    	   preparedStatement.setString(1, name);
	    	   resultSet =preparedStatement.executeQuery();
	    	   while(resultSet.next()) {
	    		   System.out.print(resultSet.getInt(1)+" | ");
   	    		   System.out.print(resultSet.getString(2)+" | ");
   	    		   System.out.print(resultSet.getString(3)+" | ");
   	    		   System.out.print(resultSet.getString(4)+" | ");
   	    		   System.out.print(resultSet.getString(5)+" | ");
   	    		   System.out.println(resultSet.getString(6)+" | ");
	    		   
	    	   }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
    }
       
       public void searchCarByPrice (Scanner scanner){
     	  try {
 			openConnection();
 			System.out.println("Enter price range to view car : ");
 			 System.out.println("Enter lower price range");
 			   float p1=scanner.nextFloat();
 			  System.out.println("Enter higher price range");
 	    	   float p2=scanner.nextFloat();
 	    	   query="SELECT * FROM car WHERE price > ? and price < ? ";
 	    	   preparedStatement=connection.prepareStatement(query);
 	    	   preparedStatement.setFloat(1, p1);
 	    	  preparedStatement.setFloat(2, p2);
 	    	   resultSet =preparedStatement.executeQuery();
 	    	   while(resultSet.next()) {
 	    		  System.out.print(resultSet.getInt(1)+" | ");
  	    		   System.out.print(resultSet.getString(2)+" | ");
  	    		   System.out.print(resultSet.getString(3)+" | ");
  	    		   System.out.print(resultSet.getString(4)+" | ");
  	    		   System.out.print(resultSet.getString(5)+" | ");
  	    		   System.out.println(resultSet.getString(6)+" | ");
 	    		   
 	    	   }
 		} catch (Exception e) {
 			e.printStackTrace();
 		}finally {
 			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 		}
     }
       public void searchCarByBrand (Scanner scanner) {
      	  try {
  			openConnection();
  			scanner.nextLine();
  			String brand=scanner.nextLine();
  	    	   query="SELECT * FROM car WHERE brand = ? ";
  	    	   preparedStatement=connection.prepareStatement(query);
  	    	   preparedStatement.setString(1, brand);
  	    	   resultSet =preparedStatement.executeQuery();
  	    	   while(resultSet.next()) {
  	    		 System.out.print(resultSet.getInt(1)+" | ");
 	    		   System.out.print(resultSet.getString(2)+" | ");
 	    		   System.out.print(resultSet.getString(3)+" | ");
 	    		   System.out.print(resultSet.getString(4)+" | ");
 	    		   System.out.print(resultSet.getString(5)+" | ");
 	    		   System.out.println(resultSet.getString(6)+" | ");
  	    		   
  	    	   }
  		} catch (Exception e) {
  			e.printStackTrace();
  		}finally {
  			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
  		}
      }
       
       public void searchCarByFuel(Scanner scanner) {
       	  try {
   			openConnection();
   			scanner.nextLine();
   			String fuelType=scanner.nextLine();
   	    	   query="SELECT * FROM car WHERE fuelType = ? ";
   	    	   preparedStatement=connection.prepareStatement(query);
   	    	   preparedStatement.setString(1, fuelType);
   	    	   resultSet =preparedStatement.executeQuery();
   	    	   while(resultSet.next()) {
   	    		 System.out.print(resultSet.getInt(1)+" | ");
 	    		   System.out.print(resultSet.getString(2)+" | ");
 	    		   System.out.print(resultSet.getString(3)+" | ");
 	    		   System.out.print(resultSet.getString(4)+" | ");
 	    		   System.out.print(resultSet.getString(5)+" | ");
 	    		   System.out.println(resultSet.getString(6)+" | ");
   	    	   }
   		} catch (Exception e) {
   			e.printStackTrace();
   		}finally {
   			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
   		}
       }
       
       public void searchCarByColor(Scanner scanner) {
        	  try {
    			openConnection();
    			scanner.nextLine();
    			String color=scanner.nextLine();
    	    	   query="SELECT * FROM car WHERE color = ? ";
    	    	   preparedStatement=connection.prepareStatement(query);
    	    	   preparedStatement.setString(1, color);
    	    	   resultSet =preparedStatement.executeQuery();
    	    	  while(resultSet.next()) {
    	    		  System.out.print(resultSet.getInt(1)+" | ");
	   	    		   System.out.print(resultSet.getString(2)+" | ");
	   	    		   System.out.print(resultSet.getString(3)+" | ");
	   	    		   System.out.print(resultSet.getString(4)+" | ");
	   	    		   System.out.print(resultSet.getString(5)+" | ");
	   	    		   System.out.println(resultSet.getString(6)+" | ");
    	    	  }
    		} catch (Exception e) {
    			e.printStackTrace();
    		}finally {
    			try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		}
        }
       
       public static void singUp(Scanner scanner) {
     	  System.out.println("Enter user id ");
     	  int id=scanner.nextInt();
     	  scanner.nextLine();
     	  System.out.println("Enter name ");
     	  String name =scanner.nextLine();
     	  System.out.println("Enter email");
     	  String email=scanner.nextLine();
     	  System.out.println("Enter password");
     	  String password=scanner.nextLine();
     	  
     	  try {
 			boolean flag=true;
 			while(flag) {
 				openConnection();
 	 			query="INSERT INTO user VALUES (?,?,?,?)";
 	 			preparedStatement=connection.prepareStatement(query);
 	 			preparedStatement.setInt(1, id);
 	 			preparedStatement.setString(2, name);
 	 			preparedStatement.setString(3, email);
 	 			preparedStatement.setString(4,password);
 	 			int res= preparedStatement.executeUpdate();
 	 			if(res==1) {
 	 				System.out.println("Singed up");
 	 				System.out.println("Welcome to application");
 	 				CarDekhoMainMenu.mainMenu();
      				flag=false;
 	 			}
 	 			else {
 	 				System.out.println("Error");
 	 				flag=false;
 	 				admin();
 	 			}
 			}
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}finally {
 			try {
 				closeConnection();
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
 		}
     	  
       }
       
       
       public static void logIn(Scanner scanner) {
         	  scanner.nextLine();
         	  System.out.println("Enter email");
         	  String email=scanner.nextLine();
         	  System.out.println("Enter password");
         	  String password=scanner.nextLine();
         	  
         	  try {
         		  boolean flag=true;
         		  while(flag) {
         			 openConnection1();
          			query="SELECT * FROM user WHERE email=? and password=?";
          			preparedStatement=connection.prepareStatement(query);
          			preparedStatement.setString(1, email);
          			preparedStatement.setString(2,password);
          			resultSet= preparedStatement.executeQuery();
          			if(resultSet.next()) {
          				System.out.println("Logged in");
          				System.out.println("Welcome to application");
          				CarDekhoMainMenu.mainMenu();
          				flag=false;
          			}
          			else {
          				System.out.println("Invalid email or password");
          				System.out.println("Try again");
          				flag=false;
          				admin();
          			}
         		  }
     			
     		} catch (Exception e) {
     			e.printStackTrace();
     		}finally {
     			try {
     				closeConnection2();
     			} catch (SQLException e) {
     				e.printStackTrace();
     			}
     		}
         	  
     	  
       }
       private static void openConnection1() throws SQLException {
     	  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","mansi@123");
       }
       private static void closeConnection2() throws SQLException {
     	  if(connection != null) {
     		  connection.close();
     	  }
     	  if(preparedStatement != null) {
     		  preparedStatement.close();
     	  }
     	  if(resultSet != null) {
     		  resultSet.close();
     	  }
       }
       
       public static void admin() {
  		 System.out.println("Enter 1 to sing up\nEnter 2 to log in");
  		 Scanner scanner = new Scanner(System.in);
  		 int choice=scanner.nextInt();
  		 switch (choice) {
  		case 1: {
  			CarOperations.singUp(scanner);
  			break;
  		}
  		case 2: {
  			CarOperations.logIn(scanner);
  			break;
  		}
  		default:
  			System.out.println("Error");
  		}
  	 }
       
       }
