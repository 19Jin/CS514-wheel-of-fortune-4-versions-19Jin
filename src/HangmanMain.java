import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

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
        //要猜的
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

    }
}
