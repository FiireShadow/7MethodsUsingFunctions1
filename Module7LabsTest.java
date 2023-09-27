package mod7labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Module7LabsTest {
	public static void main(String args[]) {
		Module7LabsTest tester = new Module7LabsTest();
		
		ArrayList<Integer> method3and6Solver = new ArrayList<Integer>();
		ArrayList<String> method4Solver = new ArrayList<String>();
		ArrayList<String> method5Solver = new ArrayList<String>();
		ArrayList<String> method7Solver = new ArrayList<String>();
		
		method3and6Solver.add(5); method3and6Solver.add(77); method3and6Solver.add(8); method3and6Solver.add(4);
		method3and6Solver.add(10); method3and6Solver.add(9); method3and6Solver.add(5); method3and6Solver.add(2);
		
		method4Solver.add("Nope"); method4Solver.add("Corp"); method4Solver.add("And");
		method4Solver.add("Cant"); method4Solver.add("Prop"); method4Solver.add("Zam");
		
		method5Solver.add("Nope"); method5Solver.add("Corp"); method5Solver.add("And");
		method5Solver.add("Cant"); method5Solver.add("Prop"); method5Solver.add("Zam");
		
		method7Solver.add("No Problem"); method7Solver.add("Corporation"); method7Solver.add("And What");
		method7Solver.add("Will not"); method7Solver.add("Props to you"); method7Solver.add("Zip Zop");
		
		tester.addInts(); //Method1
		tester.addStrings(); //Method2
		tester.removeInts(method3and6Solver); //Method3
		tester.removeStrings(method4Solver); //Method4
		tester.sortStrings(method5Solver); // Method5
		tester.countNumbersWith7(method3and6Solver); //Method6
		tester.replaceSpaces(method7Solver); //Method7
	}
	
	
	
	Scanner input = new Scanner(System.in);
	
	//Method 1: User input an arraylist of ints. Typing STOP stops the program
	public List<Integer> addInts(){
		ArrayList<Integer> adder = new ArrayList<Integer>();
		System.out.println("Type numbers to add to an arraylist. Type stop when finished.");
		while(true) {
			String inputer = input.nextLine(); 
			inputer=inputer.toUpperCase();
			if (inputer.equals("STOP")) {
				break;
			}
			else {
				try {
					Integer numberCreator = Integer.parseInt(inputer); //Change String to Integer
					adder.add(numberCreator); //Add new number to output arraylist
				}
				catch (NumberFormatException e) {
					System.out.println("Value is not a number.");
				}
			}
		}
		List<Integer> displayArrayOfInts = adder
				.stream() 
				.collect(Collectors.toList());//Ready to output list of integers
		String displayingInts = displayArrayOfInts.toString().replace("[", "").replace("]", ""); //Remove Brackets
		
		System.out.println(displayingInts);
		return new ArrayList<> (displayArrayOfInts);
		

		}
	//Method 2: User input an arraylist of Strings. Must have p. Type STOP to stop
	public ArrayList<String> addStrings() {
		ArrayList<String> onlyP = new ArrayList<String>();
		System.out.println("Type words to add to an arraylist. Type stop when finished.");
		while (true) {
			String inputP = input.nextLine();
			if (inputP.contains("p")||inputP.contains("P")) {
				onlyP.add(inputP);
			}
			if (inputP.equalsIgnoreCase("STOP")) {
				break;
			}
		}
		onlyP.remove(onlyP.size()-1); //Removes STOP
		List<String> displayP = onlyP
				.stream() 
				.collect(Collectors.toList());//Ready to output list of integers
		String displayingP = displayP.toString().replace("[", "").replace("]", ""); //Remove Brackets
		
		System.out.println(displayingP);
		return new ArrayList<> (displayP);
	}
	
	//Method 3: Remove all evens in arraylist
	public ArrayList<Integer> removeInts(ArrayList<Integer> arrList) {
		List<Integer> displayArrayOfInts = arrList
				.stream() 
				.filter((x)->x%2==1) //Filters odds
				.collect(Collectors.toList());//Ready to output list of integers
		String displayingInts = displayArrayOfInts.toString().replace("[", "").replace("]", ""); //Remove Brackets
		
		System.out.println(displayingInts);
		return new ArrayList<> (displayArrayOfInts);
	}
	//Method 4: If the next word is not in alphabetical order with the word before it, 
				 //remove that index. 
	public ArrayList<String> removeStrings(ArrayList<String> arrList) {
		int x=0;
		while (true) {
			if (arrList.get(x).compareTo(arrList.get(x+1))>=0) { //Compare to see if letters are alphabetical
				arrList.remove(x+1); //remove if not
			}
			else
				x++; //Allows while to keep looping
			if (x==arrList.size()-1) { //Prevents infinite loop once x has reached arraylist size
				break;
			}
			
		}
		for (String i : arrList) {
	        System.out.print(i + " ");
	    }
		System.out.println();
	    return arrList;
	}
	//Method 5: Sort string list based on length
	public ArrayList<String> sortStrings(ArrayList<String> arrList) {
		Collections.sort(arrList);
		for (int x=0; x<arrList.size()-1;x++) {
			for (int y=x+1; y<arrList.size();y++) {
				if (arrList.get(x).length()>(arrList.get(y).length())) { //Check if index 0 length is larger than 1 
					String temp = arrList.get(y); //Swap around
					arrList.set(y, arrList.get(x));
					arrList.set(x, temp);
				}
			}
		}
		for (String x:arrList) {
			System.out.print(x + " ");
		}
		System.out.println();
		return arrList;
	}
	
	//Method 6: Count numbers with 7 in list and return counter
		public int countNumbersWith7(ArrayList<Integer> arrList) {
			long counter = arrList
					.stream()
					.map(x -> String.valueOf(x)) //Convert to String
			        .mapToInt(str -> (int) str.chars().filter(c -> c == '7').count()) //Checks chars of string for 7s, counters
					.sum(); //adds previous counters
			System.out.println(counter);
			return (int)(counter);
		}
		
	//Method 7: Replace spaces in sentence with increasing numbers
		public ArrayList<String> replaceSpaces(ArrayList<String> arrList) {
			 int counter = 1;
			    ArrayList<String> modifiedList = new ArrayList<>();
			    
			    for (String str : arrList) { //Grabs one string at a time from the arraylist
			        StringBuilder modifiedStr = new StringBuilder();
			        
			        for (char c : str.toCharArray()) { //Grabs one char at a time from the string
			            if (c == ' ') { //If space, 
			                modifiedStr.append(counter++); //append a number
			            } else {
			                modifiedStr.append(c); //then append the rest of the word if no other spaces
			            }
			        }
			        
			        modifiedList.add(modifiedStr.toString()); //Add the newly created string to modifiedList
			    }
			    System.out.println(modifiedList);
			    return modifiedList;
		}
}
