import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class HangmanMain {
    public static void main(String[] args) {

//        WheelOfFortuneMain wheelOfFortune = new WheelOfFortuneMain();

        List<String> phraseList=null;
        // Get the phrase from a file of phrases
        try {
            phraseList = Files.readAllLines(Paths.get("phrases.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }

        // Get a random phrase from the list
        Random rand = new Random();
        int r= rand.nextInt(3); // gets 0, 1, or 2
        String phrase = phraseList.get(r);
        System.out.println(phrase);

        //build a hidden phrase with asterisks
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < phrase.length(); i++){
            if(Character.isLetter(phrase.charAt(i))){
                sb.append('*');
            }else{
                sb.append(phrase.charAt(i));
            }
        }
        System.out.println(sb);

        //user plays guessing game
        Boolean flag = true;
        while(flag){
            System.out.println("Enter a letter: ");
            Scanner keyboard = new Scanner(System.in);
            String userGuess = keyboard.nextLine().toLowerCase();
            if(!Character.isLetter(userGuess.charAt(0))){
                System.out.println("You Should Guess The Letter.");
            }else if(!phrase.toLowerCase().contains(userGuess)){
                System.out.println("Wrong Letter");
            }else if(phrase.toLowerCase().contains(userGuess)){
                for(int idx = 0; idx < phrase.length(); idx++){
                    if(phrase.toLowerCase().charAt(idx) == userGuess.charAt(0)){
                        sb.setCharAt(idx, phrase.charAt(idx));
                    }
                }
                System.out.println(sb);
                // Check if the user has guessed all letters correctly
                flag = !sb.toString().equals(phrase);
            }
        }

        System.out.println("Congratulations! You Win!!");

    }
}
