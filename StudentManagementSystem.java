import java.io.*;
import java.util.*;
public class StudentManagementSystem{
	static HashMap<String,String>studentMap=new HashMap<>();
	static final String FILE_NAME="students.txt";
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int choice;
		do{
			System.out.println("\n---StudentManagementSystem---");
			System.out.println("1.Add student");
			System.out.println("2.save to file");
			System.out.println("3.load from file");
			System.out.println("4.search by ID");
			System.out.println("5.Remove student");
			System.out.println("6.display all students");
			System.out.println("0.Exit");
            System.out.println("enter choice:");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice){
				case 1:addStudent(sc);
				break;
				case 2 :saveToFile();
				break;
				case 3:loadFromFile();
				break;
				case 4:searchStudents(sc);
				break;
				case 5:removeStudents(sc);
				break;
				case 6:displayall();
				break;
				case 0:System.out.println("Exiting program.");
				break;
				default:System.out.println("Invalid choice try again:");
			}
		}
		while(choice!=0);
		sc.close();
	}
	static void addStudent(Scanner sc){
		System.out.println("enter student ID:");
		String id=sc.nextLine();
		System.out.println("enter student name:");
		String name=sc.nextLine();
		if(studentMap.containsKey(id)){
			System.out.println("id already exists!");
		}
		else{
			studentMap.put(id,name);
			System.out.println("Student added");
		}
	}
	static void saveToFile(){
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_NAME))){
			for(Map.Entry<String,String>entry:studentMap.entrySet()){
				bw.write(entry.getKey()+','+entry.getValue());
				bw.newLine();
			}
			System.out.println("data saved to file.");
		}
		catch(IOException e){
			System.out.println("error saving to file"+e.getMessage());
		}
	}
	static void loadFromFile(){
		studentMap.clear();
		try(BufferedReader br=new BufferedReader(new FileReader(FILE_NAME))){
			String line;
			while((line=br.readLine())!=null){
				String[]parts=line.split(",");
				String id=parts[0];
				String name=parts[1];
				studentMap.put(id,name);
			}
			System.out.println("data loaded from file:");
		}
		catch(IOException e){
			System.out.println("error saving to file"+e.getMessage());
		}
	}
	
	static void searchStudents(Scanner sc){
		System.out.println("enter id to search:");
		String id=sc.nextLine();
		if(studentMap.containsKey(id)){
			System.out.println("name:"+studentMap.get(id));
		}
		else{
			System.out.println("student id not found");
		}
	}
	static void removeStudents(Scanner sc){
		System.out.println("enter id to remove:");
		String id=sc.nextLine();
		if(studentMap.remove(id)!=null){
			System.out.println("student removed");
		}
		else{
			System.out.println("student id not found");
		}
	}
	static void displayall(){
		if(studentMap.isEmpty()){
			System.out.println("no of students to display:");
		}
		else{
			System.out.println("\n student list:");
			for(Map.Entry<String,String>entry:studentMap.entrySet()){
				System.out.println("id:"+entry.getKey()+",Name:"+entry.getValue());
			}
		}
	}
}
		
		
	
				
			