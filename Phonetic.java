import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
class Phonetic{
	public static void main(String[] args){
	String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String[] alphabetArray = alphabetString.split("");
	//String[] key = {"A","B","C","D","E","F"};
	String[] ans ={"Alfa","Bravo","Charlie","Delta","Echo","Foxtrot","Golf","Hotel","India","Juliett","Kilo","Lima","Mike","November","Oscar","Papa","Quebec","Romeo","Sierra","Tango","Uniform","Victor","Whiskey","Xray","Yankee","Zulu"};


	int points = 0;

	//Create index and randomize so no duplicate questions are asked
	Integer[] index = new Integer[alphabetArray.length];
	for (int i = 0; i < index.length; i++) { 
    index[i] = i; 
	} 
	Collections.shuffle(Arrays.asList(index));

	for(Integer n:index){
		System.out.println(alphabetArray[n]);
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		if(input.equalsIgnoreCase(ans[n])){
			points++;
		}
	}
	//Print out number of Correct answers
	System.out.println("You got "+points+"/"+alphabetArray.length);
}
}
