import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
class Phonetic{
	//Initialize variables
	public static void main(String[] args){
	String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String[] alphabetArray = alphabetString.split("");
	String[] ans ={"Alfa","Bravo","Charlie","Delta","Echo","Foxtrot","Golf","Hotel","India","Juliett","Kilo","Lima","Mike","November","Oscar",
	              "Papa","Quebec","Romeo","Sierra","Tango","Uniform","Victor","Whiskey","Xray","Yankee","Zulu"};
	String inputCont = "y";
	String[] incorrectAnswers = new String[26];

	//For multiple tries
	while(inputCont.equalsIgnoreCase("y")){
		//initalize points each round
		int points = 0;
		int intNumQuestions = 26;
		//Create index so no duplicate questions are asked
		Integer[] index = new Integer[alphabetArray.length];
		for (int i = 0; i < index.length; i++) { 
	    index[i] = i; 
		} 
		//Randomize the array
		Collections.shuffle(Arrays.asList(index));
		//Ask user how many rounds they want to do
		System.out.println("How many questions?: (Type ALL if you want to get full quiz)");
		Scanner scannerNumQuestions = new Scanner(System.in);
		String inputNumQuestions = scannerNumQuestions.next();
		//Branch based on users response
		if(inputNumQuestions.equalsIgnoreCase("all")){
			points = printQuestions(intNumQuestions, index, alphabetArray,incorrectAnswers, ans,points);
		}
		//If user wants a certain number of questions
		else {
			//Convert String input into an Integer
			intNumQuestions = Integer.parseInt(inputNumQuestions);
			points = printQuestions(intNumQuestions, index, alphabetArray,incorrectAnswers, ans, points);
		} 
		//Print out number of points
		System.out.println("\n");
		System.out.println("You got "+points+"/"+intNumQuestions + ".");
		if(points != intNumQuestions){
			printResults(incorrectAnswers,ans);
		}
		System.out.println("\n");
		System.out.println("Do you want to play again? (Y/N): ");
		Scanner scannerCont = new Scanner(System.in);
		inputCont = scannerCont.next();
	}
	}
	public static int printQuestions(int intNumQuestions, Integer[] index, String[] alphabetArray, String[] incorrectAnswers, String[] ans, int points){
		for(int currentQuestion = 0; currentQuestion < intNumQuestions; currentQuestion++){
			int phoneticAlphaIndex = index[currentQuestion];
			System.out.println(alphabetArray[phoneticAlphaIndex]);
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();
			if(input.equalsIgnoreCase(ans[phoneticAlphaIndex])){
				points++;
			}
			else{
				incorrectAnswers[phoneticAlphaIndex]=input;
			}
		}
		return(points);
	}

	public static void printResults(String[] incorrectAnswers, String[] ans){
		//Print out incorrect answers
		System.out.println("These are the ones you got wrong:");
		Object[] headers={"Answer", "You Wrote"};
		System.out.format("%-9s %-10s\n", headers);
		System.out.println("------------------");
		for(String wrong:incorrectAnswers){
			if(wrong != null){
				int find = Arrays.asList(incorrectAnswers).indexOf(wrong);
				Object[] row = {ans[find],wrong};				
				System.out.format("%-10s%-10s\n", row);
			}	
		}
	}
}
