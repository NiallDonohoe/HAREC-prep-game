import java.io.IOException;
import java.util.Scanner;

public class HarecPrepGame {
    public static void main(String[] args){
    
	System.out.println("Hello - Welcome to the HAREC prep game made by Niall Donohoe - EI6HIB");
    System.out.println("PLEASE ANSWER ALL QUESTIONS IN ALL CAPS");
    System.out.println("Choose the number of questions you would like to be asked?");

    Scanner scanner = new Scanner(System.in);
    Integer numberOfQuestions = scanner.nextInt();

    int correctAnswers = 0;
    int questionsAttempted = 0;
    
    Countries countries = new Countries();
    try {
        countries.makeCountriesList();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    while (questionsAttempted < numberOfQuestions){
        
        if(countries.askQuestion()){
            correctAnswers++;
        }

        questionsAttempted++;
    }

    System.out.println("-------------------------RESULTS-------------------------");
    System.out.println("You scored " + correctAnswers*100/numberOfQuestions + "%");


    
    


}








 
}