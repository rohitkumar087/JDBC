package CRUDOpertaions;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		CRUDServices obj = new CRUDServices();
		
		while(true) {
			System.out.println(">>>>> CRUD Managment System <<<<<");
			System.out.println("1. Insert data :-");
			System.out.println("2. Update data :-");
			System.out.println("3. Delete data :-");
			System.out.println("4. ShowAll data :-");
			System.out.println("5. Exit :-");
			System.out.println("Enter your choice :-");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				int want = 0;
				System.out.println("How many rows u want to Insert: ");
				want = sc.nextInt();
				if(want<=0) {
					System.out.println("choose atleast 1");
					break;
				}
				
				
				do{
					System.out.println("Enter id: ");
					int id = sc.nextInt();
					System.out.println("Enter name: ");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.println("Enter department: ");
					String department = sc.nextLine();
					System.out.println("Enter city: ");
					String city = sc.nextLine();
					obj.insertData(id, name, department, city);
					want--;
				}while(want>0);
				
				break;
				
			case 2:
			    break;
			    
			case 3:
				System.out.println("Enter id to delete that data :");
				int id = sc.nextInt();
				obj.deleteData(id);
				break;
				
			case 4:
				obj.showData();
				break;
				
			case 5:
				System.out.println("Programme exited successfully");
				System.exit(0);
				break;
				
			default :
				System.out.println("Please enter valid choice b/w 1 to 5");
			}
			
			
			
		}
		
		
	}

}
