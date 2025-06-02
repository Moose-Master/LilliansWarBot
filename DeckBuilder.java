import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class DeckBuilder {
    String[] suits = {"♠","♥","♦","♣"};
    public ArrayList<String> db_first_belligerent = new ArrayList<>();
    public ArrayList<String> dp_second_belligerent = new ArrayList<>();
    
    ArrayList<String> masterDeck = new ArrayList<>();
    
    public DeckBuilder(){
        Scanner scan = new Scanner(System.in);
        System.out.print("How many decks: ");
        int decks = scan.nextInt();
        scan.close();
        for(int k = 0; k < decks; k++){
            for(int i = 0; i < 4;i++){
                    for(int l = 2; l < 15; l++){
                        masterDeck.add(suits[i] + l);
                    }
                }
        }

        Collections.shuffle(masterDeck);

        while(!masterDeck.isEmpty()){
            db_first_belligerent.add(masterDeck.remove(0));
            dp_second_belligerent.add(masterDeck.remove(0));
        }

        }
    }